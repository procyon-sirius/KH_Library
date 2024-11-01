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

}
