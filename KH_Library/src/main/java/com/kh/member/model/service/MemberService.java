package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MyRent;

public class MemberService {
	
	//로그인 메소드
	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().loginMember(conn,userId,userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
		
	}
	
	//회원가입 메소드	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	
	//정보수정 메소드
	public int updateMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	//나의 대출 정보 조회
	public ArrayList<MyRent> selectMyRent(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MyRent> list = new MemberDao().selectMyRent(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	
	// 아이디 중복 확인
	public boolean idCheck(String inputId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Boolean flag = new MemberDao().idCheck(conn,inputId);
		
		JDBCTemplate.close(conn);
		
		return flag;
	}

	//비밀번호 변경
	public int updatePwd(HashMap<String, String> map) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updatePwd(conn,map);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
											
		return result;
	}
	
	//책 반납
	public int bookReturn(int bookId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().bookReturn(conn,bookId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
						
		return result;
	}
	
	
	
	

}
