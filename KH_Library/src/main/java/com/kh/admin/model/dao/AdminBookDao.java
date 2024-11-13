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
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;
import com.kh.search.model.dao.SearchDao;

public class AdminBookDao {
	private Properties prop = new Properties();
	
	public AdminBookDao() {

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

	public int removeCkNBook(Connection conn, int bookId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("removeCkNBook");
		
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

	public int removeCkNCategory(Connection conn, int bookId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("removeCkNCategory");
		
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

	public int removeAllNCategory(Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("removeAllNCategory");
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int removeAllNBook(Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("removeAllNBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int bookCategoryDelete(Connection conn, String cno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("bookCategoryDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int bookCategoryChangeZero(Connection conn, String cno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("bookCategoryChangeZero");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int bookCategoryInfoDelete(Connection conn, String cno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("bookCategoryInfoDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertNewBookCategoryInfo(Connection conn, BookCategoryInfo cInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertNewBookCategoryInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cInfo.getCategoryNo());
			pstmt.setString(2, cInfo.getCategoryName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
}
