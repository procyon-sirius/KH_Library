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
	
	public ArrayList<Member> memberList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		String sql = prop.getProperty("memberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member( rset.getInt("USER_NO"),
									 rset.getString("USER_ID"),
									 rset.getString("USER_PWD"),
									 rset.getString("USER_NAME"),
									 rset.getString("USER_NNO"),
									 rset.getString("PHONE"),
									 rset.getString("EMAIL"),
									 rset.getString("ADDRESS"),
									 rset.getDate("ENROLL_DATE"),
									 rset.getDate("MODIFY_DATE"),
									 rset.getInt("RENT_LIMIT"),
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

	public int deleteMember(Connection conn, int userNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int rollbackMember(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("rollbackMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Member> findUserId(Connection conn, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		String sql = prop.getProperty("findUserId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member( rset.getInt("USER_NO"),
									 rset.getString("USER_ID"),
									 rset.getString("USER_PWD"),
									 rset.getString("USER_NAME"),
									 rset.getString("USER_NNO"),
									 rset.getString("PHONE"),
									 rset.getString("EMAIL"),
									 rset.getString("ADDRESS"),
									 rset.getDate("ENROLL_DATE"),
									 rset.getDate("MODIFY_DATE"),
									 rset.getInt("RENT_LIMIT"),
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

	public ArrayList<Member> findUserName(Connection conn, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		String sql = prop.getProperty("findUserName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member( rset.getInt("USER_NO"),
									 rset.getString("USER_ID"),
									 rset.getString("USER_PWD"),
									 rset.getString("USER_NAME"),
									 rset.getString("USER_NNO"),
									 rset.getString("PHONE"),
									 rset.getString("EMAIL"),
									 rset.getString("ADDRESS"),
									 rset.getDate("ENROLL_DATE"),
									 rset.getDate("MODIFY_DATE"),
									 rset.getInt("RENT_LIMIT"),
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

	public int realDelete(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("realDelete");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
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
