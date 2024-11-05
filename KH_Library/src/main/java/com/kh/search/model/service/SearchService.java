package com.kh.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.book.model.dao.BookDao;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;
import com.kh.search.model.dao.SearchDao;

public class SearchService {

	public ArrayList<BookCategoryInfo> selectBookCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BookCategoryInfo> bookcList = new SearchDao().selectBookCategoryList(conn);
		
		JDBCTemplate.close(conn);
		
		return bookcList;
	}

	public ArrayList<Book> selectSearchList(String[] keyCategory, String category, PageInfo pi) {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> bookList = new SearchDao().selectSearchList(conn, keyCategory, category, pi);
		
		JDBCTemplate.close(conn);
		
		return bookList;
	}

	public int listCount(String[] keyCategory, String category) {
		Connection conn = JDBCTemplate.getConnection();

		int listCount = new SearchDao().listCount(conn,keyCategory,category);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	
}
