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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
