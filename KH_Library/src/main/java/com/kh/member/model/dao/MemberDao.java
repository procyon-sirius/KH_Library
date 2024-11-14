package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

	
	
	//아이디 중복체크
	public Boolean idCheck(Connection conn, String inputId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		boolean flag = false;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			
			rset = pstmt.executeQuery();
			
			flag = rset.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
			
		return flag;
	}

	//비밀번호 변경	
	public int updatePwd(Connection conn, HashMap<String, String> map) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, map.get("pwdUpdate"));
			pstmt.setString(2, map.get("userId"));
			pstmt.setString(3, map.get("userPwd"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
												
		return result;
	}
	
	//책 반납
	public int bookReturn(Connection conn, int bookId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("bookReturn");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookId);
			
			result= pstmt.executeUpdate();
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
				
		return result;
	}
	
	//예약현황
	public ArrayList<MyRent> reserveMyBook(Connection conn, int userNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		ArrayList<MyRent> reList = new ArrayList<>();
		
		String sql = prop.getProperty("reserveMyBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				reList.add(new MyRent(rset.getInt("BOOK_ID"),
									  rset.getString("BOOK_TITLE"),
									  rset.getString("BOOK_AUTHOR"),
									  rset.getString("PUBLISHER")
										));
							
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
				
		return reList;
	}
	
	// 대출 책의 상태값 조회
	public String selectStatus(Connection conn, int bookId) {
		
		PreparedStatement pstmt = null;		
		ResultSet rset = null;
				
		String sql = prop.getProperty("selectStatus");
		
		String bs = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1 , bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {			
			 	bs = rset.getString("STATUS");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return bs;
	}

	public int reserveCheck(int bookId) {
		
		return 0;
	}
	

}
