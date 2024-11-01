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
	
	public int hopeBookInsert(Connection conn, HopeBook h) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("hopeBookInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(h.getHopeUser()));
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

	public ArrayList<HopeBook> selectHopeList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HopeBook> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectHopeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new HopeBook(rset.getInt("HOPE_NUM"),
									  rset.getString("USER_ID"),
									  rset.getString("HOPE_TITLE"),
									  rset.getDate("HOPE_DATE"),
									  rset.getString("HOPE_PUBLIC")
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

	public HopeBook hopeBookDetail(Connection conn, int hno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HopeBook h = null;
		
		String sql = prop.getProperty("hopeBookDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				h = new HopeBook(rset.getString("USER_ID"),
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

}
