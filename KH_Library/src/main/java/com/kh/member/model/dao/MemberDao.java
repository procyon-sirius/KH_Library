package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

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
	

}
