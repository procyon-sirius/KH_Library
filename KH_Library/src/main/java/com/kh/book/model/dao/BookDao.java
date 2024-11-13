package com.kh.book.model.dao;

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
	
	public ArrayList<Book> allList(Connection conn, String age, String order, String ad, PageInfo pi) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();

		String sql = "";
		if(age.equals("AGE_RANK")) {
			sql ="SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Z.* "
				+ "FROM (SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
						+ "FROM BOOK "
						+ "JOIN BOOK_CATEGORY USING(BOOK_ID) "
						+ "WHERE AGE_RANK = AGE_RANK "
						+ "GROUP BY BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
						+ "ORDER BY "+order+" "+ad+")"
					+ " Z) "
				+ "WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
			
		}else {
			sql ="SELECT * "
					+ "FROM (SELECT ROWNUM RNUM, Z.* "
					+ "FROM (SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
							+ "FROM BOOK "
							+ "JOIN BOOK_CATEGORY USING(BOOK_ID) "
							+ "WHERE AGE_RANK = '"+age+"' "
							+ "GROUP BY BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
							+ "ORDER BY "+order+" "+ad+")"
						+ " Z) "
					+ "WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
				
		}

	    try {
	    	stmt = conn.createStatement();
	    	
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
					list.add(new Book(rset.getInt("BOOK_ID")
										, rset.getString("BOOK_TITLE")
										, rset.getString("BOOK_AUTHOR")
										, rset.getString("PUBLISHER")
										, rset.getInt("PUBLISH_DATE")
										, rset.getDate("ENROLL_DATE")
										, rset.getString("STATUS")
										, rset.getString("IMG_NAME")
										));
			}
	    }catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Book> changeCategory(Connection conn, int cno, String age, String order, String ad, PageInfo pi) {

		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		String sql ="";
		if(age.equals("AGE_RANK")) {
			sql ="SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Z.* "
				+ "FROM (SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
						+ "FROM BOOK "
						+ "JOIN BOOK_CATEGORY USING(BOOK_ID) "
						+ "WHERE CATEGORY_NO = "+cno+" AND AGE_RANK = AGE_RANK "
						+ "GROUP BY BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
						+ "ORDER BY "+order+" "+ad+")"
					+ " Z) "
				+ "WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
			
		}else {
			sql ="SELECT * "
					+ "FROM (SELECT ROWNUM RNUM, Z.* "
					+ "FROM (SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
							+ "FROM BOOK "
							+ "JOIN BOOK_CATEGORY USING(BOOK_ID) "
							+ "WHERE CATEGORY_NO = "+cno+" AND AGE_RANK = '"+age+"' "
							+ "GROUP BY BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, PUBLISHER, PUBLISH_DATE, ENROLL_DATE, STATUS, IMG_NAME "
							+ "ORDER BY "+order+" "+ad+")"
						+ " Z) "
					+ "WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
				
		}

		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
					list.add(new Book(rset.getInt("BOOK_ID")
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
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
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
							rset.getString("SUMMARY"),
							rset.getString("IMG_NAME"));
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
	



	public int clistCount(Connection conn, int cno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int clistCount = 0;
		String sql = prop.getProperty("clistCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				clistCount = rset.getInt("COUNT");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return clistCount;
	}
	
	public int countRentLimit(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countRentLimit");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("RENT_LIMIT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int countReserveUser(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countReserveUser");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("RESCOUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int insertReserveBook(Connection conn, int bookId, int userNo) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReserveBook");
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


	public int updateBookStatusR(Connection conn, int bookId) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("statusR");
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


	public ArrayList<Book> bookRecommend(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bookRecommend");
		ArrayList<Book> blist = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset.next()) {
					blist.add(new Book(rset.getInt("BOOK_ID")
									, rset.getString("BOOK_TITLE")
									, rset.getString("BOOK_AUTHOR")
									, rset.getString("IMG_NAME")
								));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return blist;
	}
	
	public ArrayList<Book> monthNewBook(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Book> list = new ArrayList<>();

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		String sql = prop.getProperty("newListM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID")
								, rset.getString("BOOK_TITLE")
								, rset.getString("BOOK_AUTHOR")
								, rset.getString("IMG_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Book> dayNewBook(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Book> list = new ArrayList<>();

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		String sql = prop.getProperty("newListD");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID")
								, rset.getString("BOOK_TITLE")
								, rset.getString("BOOK_AUTHOR")
								, rset.getString("IMG_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}


	public ArrayList<Book> weekNewBook(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Book> list = new ArrayList<>();

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage()*pi.getBoardLimit();
		
		String sql = prop.getProperty("newListW");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Book(rset.getInt("BOOK_ID")
								, rset.getString("BOOK_TITLE")
								, rset.getString("BOOK_AUTHOR")
								, rset.getString("IMG_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}


	public int dayListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("dayListCount");
		
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


	public int weekListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("weekListCount");
		
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


	public int monthListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("monthListCount");
		
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



	public ArrayList<BookCategoryInfo> selectBookCategory(Connection conn, int bno) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookCategory");
		ArrayList<BookCategoryInfo> biList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				biList.add(new BookCategoryInfo(rset.getInt("CATEGORY_NO"),
							  			  		rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return biList;
	}


	public Book monthRecommendBook(Connection conn, int tb) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book b = new Book();
		String sql = prop.getProperty("selectBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tb);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Book(rset.getInt("BOOK_ID"),
							 rset.getString("BOOK_TITLE"),
							 rset.getString("BOOK_AUTHOR"),
							 rset.getString("SUMMARY"),
							 rset.getString("IMG_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}


	public int topBook(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int tb = 0;
		String sql = prop.getProperty("topBook");
		
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				tb = rset.getInt("BOOK_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return tb;
	}



	
	
}