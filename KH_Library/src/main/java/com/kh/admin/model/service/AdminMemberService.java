package com.kh.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminMemberDao;
import com.kh.book.model.vo.Rent;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class AdminMemberService {
	
	public ArrayList<Member> memberList() {
		
		Connection conn= JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().memberList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int deleteMember(int userNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().deleteMember(conn,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int rollbackMember(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().rollbackMember(conn,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<Member> findUserId(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().findUserId(conn,search);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public ArrayList<Member> findUserName(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().findUserName(conn,search);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public int realDelete(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().realDelete(conn,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	

	public int rentCount(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new AdminMemberDao().rentCount(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	public Member memberInfo(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member mem = new AdminMemberDao().memberInfo(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		return mem;
	}

	public int updateLimit(int rentLimit, int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().updateLimit(conn,rentLimit,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	

}
