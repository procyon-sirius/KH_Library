package com.kh.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;
import com.kh.search.model.dao.SearchDao;

public class SearchService {

	public ArrayList<BookCategoryInfo> selectBookCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BookCategoryInfo> bookcList = new SearchDao().selectBookCategoryList(conn);
		
		JDBCTemplate.close(conn);
		
		return bookcList;
	}

	public ArrayList<Book> selectSearchList(String category, String keyword) {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> bookList = new SearchDao().selectSearchList(conn, category, keyword);
		
		JDBCTemplate.close(conn);
		
		return bookList;
	}
	
	
}
