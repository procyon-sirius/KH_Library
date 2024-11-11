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
import com.kh.common.PageInfo;

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


	public ArrayList<Book> selectSearchList(Connection conn, String[] keyCategory, String category, PageInfo pi) {
		PreparedStatement pstmt = null;
		ArrayList<Book> bookList = new ArrayList<>();
		String sql = prop.getProperty("selectSearchResultList");
		ResultSet rset = null;
		

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, keyCategory[0]);
			pstmt.setString(3, keyCategory[1]);
			pstmt.setString(4, keyCategory[2]);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bookList.add(new Book(rset.getInt("BOOK_ID")
									, rset.getString("BOOK_TITLE")
									, rset.getString("BOOK_AUTHOR")
									, rset.getString("PUBLISHER")
									, rset.getInt("PUBLISH_DATE")
									, rset.getDate("ENROLL_DATE")
									, rset.getString("STATUS")
									, rset.getString("IMG_NAME")
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


	public int listCount(Connection conn, String[] keyCategory, String category) {
		PreparedStatement pstmt = null;
		ArrayList<Book> bookList = new ArrayList<>();
		String sql = prop.getProperty("listCount");
		ResultSet rset = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, keyCategory[0]);
			pstmt.setString(3, keyCategory[1]);
			pstmt.setString(4, keyCategory[2]);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
	
}
