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
	
	public ArrayList<Book> allList(String age, String order, String ad, PageInfo pi) {
			
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().allList(conn,age,order,ad,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Book> changeCategory(int cno, String age, String order, String ad, PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().changeCategory(conn,cno,age,order,ad,pi);
		
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
		
		//인당 대출권수
		
		int rLimit = new BookDao().countRentLimit(conn, userNo);
		int resCount = new BookDao().countReserveUser(conn,userNo);
		
		if(resCount+rCount < rLimit) {
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

	

	public int clistCount(int cno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int clistCount = new BookDao().clistCount(conn, cno);
		
		JDBCTemplate.close(conn);
		
		return clistCount;
	}



	public int insertReserveBook(int bookId, int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		int resCount = new BookDao().countReserveUser(conn,userNo);

		int rCount = new BookDao().countRentUser(conn, userNo);
		int rLimit = new BookDao().countRentLimit(conn, userNo);
		if(resCount+rCount < rLimit) {
			
			result = new BookDao().insertReserveBook(conn, bookId, userNo);
			//book의 status를 R(예약중)로 변경
			int updateBookStatusR = new BookDao().updateBookStatusR(conn, bookId);
			
			if(result*updateBookStatusR>0) {//둘다 정상처리
				JDBCTemplate.commit(conn);
			}else {	//둘중 하나라도 오류일경우
				JDBCTemplate.rollback(conn);
			}
		}else {
			result = -1; //예약 최대치 초과 (예약 최대치 = 현재 예약건수 + 현재 대출 권수)
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Book> bookRecommend() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> blist = new BookDao().bookRecommend(conn);
		
		JDBCTemplate.close(conn);
		
		return blist;
	}
	
	public ArrayList<Book> monthNewBook(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().monthNewBook(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Book> dayNewList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().dayNewBook(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Book> weekNewList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().weekNewBook(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int dayListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int dayListCount = new BookDao().dayListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return dayListCount;
	}

	public int weekListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int weekListCount = new BookDao().weekListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return weekListCount;
	}

	public int monthListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int monthListCount = new BookDao().monthListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return monthListCount;
	}
	



}
