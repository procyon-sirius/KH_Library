package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Reserve;
import com.kh.book.model.dao.BookDao;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MyHope;
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
	
	//도서 예약 목록
	public ArrayList<MyRent> reserveMyBook(int userNo) {
			
		Connection conn = JDBCTemplate.getConnection();
			
		ArrayList<MyRent> reList = new MemberDao().reserveMyBook(conn,userNo);
			
		JDBCTemplate.close(conn);
			
		return reList;
	}
	
//	//도서 예약 삭제
//	public int reserveDelete(int bookId) {
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = new MemberDao().reserveDelete(conn,bookId);
//		
//		if(result>0) {
//			JDBCTemplate.commit(conn);
//		}else {
//			JDBCTemplate.rollback(conn);
//		}
//		JDBCTemplate.close(conn);
//		
//		return result;		
//	}
		
	//책 반납
	public int bookReturn(int bookId) {
		
		Connection conn = JDBCTemplate.getConnection();

		int userNo = new MemberDao().reserveCheck(conn,bookId);
		//책 반납
		int result = new MemberDao().bookReturn(conn,bookId);
							
		int result2 = 1;
		if(userNo==0) {	//예약자 없을시
			//책 상태 변경(대출가능)
			result2 = new MemberDao().bStatus(conn,bookId);	
		}
		
		if(result*result2>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
						
		return result*result2;
	}
	//예약자 확인
	public int checkReserve(int bookId) {
		Connection conn = JDBCTemplate.getConnection();
		//예약자 확인
		int userNo = new MemberDao().reserveCheck(conn,bookId);
		
		if(userNo!=0) {//예약 있을때
			//예약 status 변경
			int changeResStatus = new MemberDao().changeResReturnBook(conn, bookId);
			
			if(changeResStatus > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}
		JDBCTemplate.close(conn);
		return 0;
	}
	//반납 연기
	public int bookDelay(int bookId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().bookDelay(conn,bookId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//탈퇴
	public int deleteMember(String userId, String userPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn,userId,userPwd);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	//나의 신청 현황
	public ArrayList<MyHope> selectMyHope() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MyHope> list = new MemberDao().selectMyHope(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public Reserve bookReserve(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Reserve r = new MemberDao().bookReserve(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		return r;
	}
	
	
	
		

}
