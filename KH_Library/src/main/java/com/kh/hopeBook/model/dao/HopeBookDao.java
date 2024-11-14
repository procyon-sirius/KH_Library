package com.kh.hopeBook.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.vo.HopeBook;
import com.kh.hopeBook.model.vo.PageInfo;

public class HopeBookDao {

	private Properties prop = new Properties();
	
	public HopeBookDao() {
		String filePath = HopeBookDao.class.getResource("/resources/mappers/hopeBook-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//책 신청
	public int hopeBookInsert(Connection conn, HopeBook h) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("hopeBookInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, h.getHopeUser());
			pstmt.setString(2, h.getHopeTitle());
			pstmt.setString(3, h.getHopeAutor());
			pstmt.setString(4, h.getHopeContent());
			pstmt.setString(5, h.getHopePublic());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//신청현황 리스트 뽑기
	public ArrayList<HopeBook> selectHopeList(Connection conn,PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HopeBook> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectHopeList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new HopeBook(rset.getInt("HOPE_NUM"),
									  rset.getString("USER_ID"),
									  rset.getString("HOPE_TITLE"),
									  rset.getDate("HOPE_DATE"),
									  rset.getString("HOPE_PUBLIC"),
									  rset.getString("HOPE_STATE")
									 ));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	

	public ArrayList<HopeBook> selectHopeListDESC(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HopeBook> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectHopeListDESC");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new HopeBook(rset.getInt("HOPE_NUM"),
									  rset.getString("USER_ID"),
									  rset.getString("HOPE_TITLE"),
									  rset.getDate("HOPE_DATE"),
									  rset.getString("HOPE_PUBLIC"),
									  rset.getString("HOPE_STATE")
									 ));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}


	//상세보기
	public HopeBook hopeBookDetail(Connection conn, int hopeNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HopeBook h = null;
		
		String sql = prop.getProperty("hopeBookDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hopeNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				h = new HopeBook(rset.getInt("HOPE_NUM"),
								 rset.getInt("HOPE_USER"),
								 rset.getString("USER_ID"),
								 rset.getString("HOPE_TITLE"),
								 rset.getString("HOPE_AUTHOR"),
								 rset.getString("HOPE_CONTENT"),
								 rset.getDate("HOPE_DATE"),
								 rset.getString("HOPE_PUBLIC"),
								 rset.getString("HOPE_STATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return h;
	}

	//게시글 삭제
	public int deleteHope(Connection conn, int hopeNum) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteHope");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hopeNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}

	//신청 확인(관리자)
	public int hopeCheck(Connection conn, int hopeNum) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("hopeCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hopeNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
