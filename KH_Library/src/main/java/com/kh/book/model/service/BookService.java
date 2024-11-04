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
	
	public ArrayList<Book> allList(PageInfo pi) {
			
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().allList(conn,pi);
		
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
			
			if(result*increaseRentBook>0) {//둘다 정상처리
				JDBCTemplate.commit(conn);
			}else {	//둘중 하나라도 오류일경우
				JDBCTemplate.rollback(conn);
			}
		}else {
			result = -1; //대출권수 최대일때
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Book> changeCategory(int cno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().changeCategory(conn,cno);
		
		JDBCTemplate.close(conn);
		
		return list;
	}



}
