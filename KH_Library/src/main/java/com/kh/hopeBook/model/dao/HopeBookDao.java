package com.kh.hopeBook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.vo.HopeBook;

public class HopeBookDao {

	private Properties prop = new Properties();
	
	public int hopeBookInsert(Connection conn, HopeBook h) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("hopeBookInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, h.getHopeUser());
			pstmt.setString(2, h.getHopeTitle());
			pstmt.setString(3, h.getHopeAutor());
			pstmt.setString(4, h.getHopeContent());
			
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
