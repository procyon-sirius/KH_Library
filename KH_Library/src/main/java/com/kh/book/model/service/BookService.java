package com.kh.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.book.model.dao.BookDao;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategory;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class BookService {


	public int listCount() {

		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new BookDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	public ArrayList<Book> allList(PageInfo pi, String age, String order, String ud) {
			
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().allList(conn,pi,age,order,ud);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public Book selectBook(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Book b = new BookDao().selectBook(conn,bno);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	public ArrayList<BookCategoryInfo> selectCategory() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BookCategoryInfo> bci = new BookDao().selectCategory(conn);
		
		JDBCTemplate.close(conn);
		
		return bci;
	}


	public int insertRentBook(int bookId, int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int rCount = new BookDao().countRentUser(conn, userNo);
		int result = 0;
		
		//인당 대출권수 최대 5권
		if(rCount<5) {
			//rent테이블에 추가
			result = new BookDao().insertRentBook(conn, bookId, userNo);
			//book의 rentcount 1증가
			int increaseRentBook = new BookDao().increaseRentCount(conn, bookId); 
			//book의 status를 B(예약가능)로 변경
			int updateBookStatusB = new BookDao().updateBookStatusB(conn, bookId);
			
			if(result*increaseRentBook*updateBookStatusB>0) {//셋다 정상처리
				JDBCTemplate.commit(conn);
			}else {	//셋중 하나라도 오류일경우
				JDBCTemplate.rollback(conn);
			}
		}else {
			result = -1; //대출권수 최대일때
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Book> changeCategory(int cno, PageInfo pi, String age, String order, String ud) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().changeCategory(conn,cno,pi,age,order,ud);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int clistCount(int cno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int clistCount = new BookDao().clistCount(conn, cno);
		
		JDBCTemplate.close(conn);
		
		return clistCount;
	}



}
