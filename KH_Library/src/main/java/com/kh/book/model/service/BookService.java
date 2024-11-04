package com.kh.book.model.service;

import java.sql.Connection;

import com.kh.book.model.dao.BookDao;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;

public class BookService {

	public Book selectBook(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Book b = new BookDao().selectBook(conn,bno);
		
		JDBCTemplate.close(conn);
		
		return b;
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

}
