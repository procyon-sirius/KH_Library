package com.kh.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.book.model.dao.BookDao;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class BookService {


	public int listCount() {

		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new BookDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectList(PageInfo pi) {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new BookDao().selectList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public Book selectBook(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Book b = new BookDao().selectBook(conn,bno);
		
		JDBCTemplate.close(conn);
		
		return b;
	}
}
