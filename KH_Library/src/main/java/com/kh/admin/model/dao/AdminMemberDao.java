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
import com.kh.book.model.vo.Rent;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;
import com.kh.search.model.dao.SearchDao;

public class AdminMemberDao {
	private Properties prop = new Properties();
	
	public AdminMemberDao() {

		String filePath = SearchDao.class.getResource("/resources/mappers/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int rentCount(Connection conn, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("rentCount");
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return count;
	}

	public Member memberInfo(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memberInfo");
		Member mem = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mem = new Member(rset.getInt("USER_NO"),
								 rset.getString("USER_ID"),
								 rset.getString("USER_NAME"),
								 rset.getInt("RENT_LIMIT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return mem;
	}

	public int updateLimit(Connection conn, int rentLimit, int userNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateLimit");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rentLimit);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	
	
}
