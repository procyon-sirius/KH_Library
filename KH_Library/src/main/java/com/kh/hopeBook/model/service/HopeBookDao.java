package com.kh.hopeBook.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hopeBook.model.vo.HopeBook;

public class HopeBookDao {

	private Properties prop = new Properties();
	
	public int hopeBookInsert(Connection conn, HopeBook h) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("hopeBookInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
