package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MyRent;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String filePath = MemberDao.class.getResource("/resources/mappers/member-mapper.xml").getPath();
		
			try {
				prop.loadFromXML(new FileInputStream(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	//로그인 메소드
	public Member loginMember(Connection conn,String userId,String userPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO"),
						       rset.getString("USER_ID"),
						       rset.getString("USER_PWD"),
						       rset.getString("USER_NAME"),
						       rset.getString("USER_NNO"),
						       rset.getString("PHONE"),
						       rset.getString("EMAIL"),
						       rset.getString("ADDRESS"),
						       rset.getDate("ENROLL_DATE"),
						       rset.getDate("MODIFY_DATE"),
						       rset.getString("STATUS"));
							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return m;
		
	}
	
	//회원가입 메소드
	public int insertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserNno());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getAddress());
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
			
		return result;
	}
	
	//정보수정
	public int updateMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
				
		return result;
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
	
	//나의 대출 정보 조회
	public ArrayList<MyRent> selectMyRent(Connection conn,int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<MyRent> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectMyRent");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MyRent(rset.getInt("BOOK_ID"),
									rset.getString("BOOK_TITLE"),
									rset.getString("BOOK_AUTHOR"),
									rset.getString("PUBLISHER"),
									rset.getDate("RETURN_DATE")));
				
			}
			
			pstmt.setInt(1, userNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
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
	

}
