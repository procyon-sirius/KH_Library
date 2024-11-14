package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.book.model.service.BookService;
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
		
		//RESERVE 테이블에 반납하는 도서가 예약되어있을때 : 리턴값=USER_NO / 예약x : 리턴값=0
		int userNo = new MemberDao().reserveCheck(bookId);
		
		int result = new MemberDao().bookReturn(conn,bookId);
		
		//기본값 1
		int rent = 1;
		if(userNo!=0) {//userNo가 검색되었을때(예약자가 있을때)
			//대출처리(성공:1, 실패:0)
			rent = new BookService().insertRentBook(bookId, userNo);
		}
		
		if(rent*result>0) {//반납과 예약자 대출이 모두 성공한 경우(예약자 없는경우는 기본값 1이라 자동 성공처리)
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
						
		return result;
	}
	
	//도서 예약 목록
	public ArrayList<MyRent> reserveMyBook(int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MyRent> reList = new MemberDao().reserveMyBook(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		return reList;
	}
	
	// 대출 책의 상태값 조회
	public String selectStatus(int bookId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String bs = new MemberDao().selectStatus(conn,bookId);
		
		JDBCTemplate.close(conn);
		
		return bs;
	}
		
	

}
