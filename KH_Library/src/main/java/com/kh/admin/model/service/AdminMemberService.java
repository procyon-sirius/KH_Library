package com.kh.admin.model.service;

import java.sql.Connection;

import com.kh.admin.model.dao.AdminMemberDao;
import com.kh.book.model.vo.Rent;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class AdminMemberService {

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
