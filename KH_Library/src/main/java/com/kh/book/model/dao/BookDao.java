package com.kh.book.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategory;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

import oracle.jdbc.proxy.annotation.Pre;

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


	public int listCount(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("listCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Book> allList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		String sql = prop.getProperty("allList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID"),
								  rset.getString("BOOK_TITLE"),
								  rset.getString("BOOK_AUTHOR"),
								  rset.getString("PUBLISHER"),
								  rset.getInt("PUBLISH_DATE"),
								  rset.getDate("ENROLL_DATE"),
								  rset.getString("STATUS")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
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


	public ArrayList<BookCategoryInfo> selectCategory(Connection conn) {
		
		PreparedStatement pstmt = null;		
		ResultSet rset = null;
		ArrayList<BookCategoryInfo> bci = new ArrayList<>();
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bci.add(new BookCategoryInfo(rset.getInt("CATEGORY_NO"),
											  rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bci;
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


	public int updateBookStatusB(Connection conn, int bookId) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("statusB");
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
	
	public ArrayList<Book> changeCategory(Connection conn, int cno, PageInfo pi) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("changeCategory");
		ArrayList<Book> list = new ArrayList<>();
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID"),
								  rset.getString("BOOK_TITLE"),
								  rset.getString("BOOK_AUTHOR"),
								  rset.getString("PUBLISHER"),
								  rset.getInt("PUBLISH_DATE"),
								  rset.getDate("ENROLL_DATE"),
								  rset.getString("STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}


	
	
	
}
