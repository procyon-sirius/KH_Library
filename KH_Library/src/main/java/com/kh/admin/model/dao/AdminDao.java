package com.kh.admin.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;
import com.kh.search.model.dao.SearchDao;

public class AdminDao {
	private Properties prop = new Properties();
	
	public AdminDao() {

		String filePath = SearchDao.class.getResource("/resources/mappers/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Book> searchBook(Connection conn, String category, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		String sql =  "SELECT BOOK_ID"
					+ "		, BOOK_TITLE"
					+ "		, BOOK_AUTHOR"
					+ "		, PUBLISH_DATE"
					+ "		, ENROLL_DATE"
					+ "		, AGE_RANK"
					+ "	    , STATUS "
					+ "FROM BOOK "
					+ "WHERE "+category+" LIKE '%"+keyword+"%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID")
								, rset.getString("BOOK_TITLE")
								, rset.getString("BOOK_AUTHOR")
								, rset.getInt("PUBLISH_DATE")
								, rset.getDate("ENROLL_DATE")
								, rset.getString("AGE_RANK")
								, rset.getString("STATUS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}

	public ArrayList<Book> selectAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		String sql = prop.getProperty("selectAllBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID")
								, rset.getString("BOOK_TITLE")
								, rset.getString("BOOK_AUTHOR")
								, rset.getInt("PUBLISH_DATE")
								, rset.getDate("ENROLL_DATE")
								, rset.getString("AGE_RANK")
								, rset.getString("STATUS")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int statusChangeBook(Connection conn, int bookId, String changeStatus) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("changeStatusBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changeStatus);
			pstmt.setInt(2, bookId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
}
