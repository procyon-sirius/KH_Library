package com.kh.book.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;

public class BookDao {
	
	private Properties prop = new Properties();
	
	public BookDao() {
		
		String filePath = BookDao.class.getResource("/resources/mappers/book-mapper.xml").getPath();
	
		try {
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book selectBook(Connection conn, int bno) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book b = new Book();
		String sql = prop.getProperty("selectBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Book(rset.getInt("BOOK_ID"),
							 rset.getString("BOOK_TITLE"),
							 rset.getString("BOOK_AUTHOR"),
							 rset.getString("PUBLISHER"),
							 rset.getInt("PUBLISH_DATE"),
							 rset.getDate("ENROLL_DATE"),
							 rset.getString("STATUS"),
							 rset.getString("SUMMARY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}

	public int insertRentBook(Connection conn, int bookId, int userNo) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRentBook");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countRentUser(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countRentUser");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("RCOUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int increaseRentCount(Connection conn, int bookId) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseRentCount");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
