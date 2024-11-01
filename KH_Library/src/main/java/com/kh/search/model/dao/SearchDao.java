package com.kh.search.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;

public class SearchDao {

	private Properties prop = new Properties();
	
	
	public SearchDao() {

		String filePath = SearchDao.class.getResource("/resources/mappers/search-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<BookCategoryInfo> selectBookCategoryList(Connection conn) {
		PreparedStatement pstmt = null;
		ArrayList<BookCategoryInfo> bookcList = new ArrayList<>();
		String sql = prop.getProperty("selectBookCategoryList");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookcList.add(new BookCategoryInfo(rset.getInt("CATEGORY_NO"),rset.getString("CATEGORY_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bookcList;
	}


	public ArrayList<Book> selectSearchList(Connection conn, String category, String keyword) {
		PreparedStatement pstmt = null;
		ArrayList<Book> bookList = new ArrayList<>();
		String sql = prop.getProperty("selectSearchResultList");
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, keyword);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookList.add(new Book(rset.getInt("BOOK_ID")
									, rset.getString("BOOK_TITLE")
									, rset.getString("BOOK_AUTHOR")
									, rset.getString("PUBLISHER")
									, rset.getInt("PUBLISH_DATE")
									));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bookList;
	}
	
}
