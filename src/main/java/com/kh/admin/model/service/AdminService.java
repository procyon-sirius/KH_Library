package com.kh.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;

public class AdminService {

	public ArrayList<Book> searchBook(String category, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminDao().searchBook(conn,category, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Book> selectAllBook() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminDao().selectAllBook(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
