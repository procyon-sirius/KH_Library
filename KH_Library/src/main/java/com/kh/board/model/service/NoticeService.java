package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import com.kh.board.model.dao.NoticeDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Notice;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class NoticeService {

	
	
	// 게시글 조회
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn,pi);
		JDBCTemplate.close(conn);
		
		return list;		
		
	}
	
	
	// 조회수 증가 
	public int increaseCount(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().increaseCount(conn,nno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	// 공지사항 상세조회
	public Notice selectNotice(int nno) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectNotice(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return n;
	}
	
	
	// 이전글 다음글 조회
	public ArrayList<Notice> preNnext(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> preNnext = new NoticeDao().preNnext(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return preNnext;
		
	}

	
	// 게시글 수 조회
	public int listCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new NoticeDao().listCount(conn);

		JDBCTemplate.close(conn);
		
		return listCount;
	}

	
	
	// 공지사항 수정
	public int updateNotice(String title, String content, int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn,title,content,nno);
	
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	// 공지사항 삭제
	public int deleteNotice(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	// 공지사항 작성
	public int insertNotice(Notice n, Attachment at) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int noticeNo = new NoticeDao().selectBoardNo(conn);
		if(noticeNo !=0) { // 추출한 게시글 번호가 0이 아닐때 (제대로 추출되었을때)
			// 게시글 객체에 추출한 게시글 번호 넣어주기
			n.setNoticeNo(noticeNo);
			int result = new NoticeDao().insertNotice(conn,n); // 게시글 등록이 잘 되었는지 여부
			// 첨부파일 등록처리 후 사용할 변수
			int result2 = 1; // 첨부파일이 없어도 게시글 등록처리는 될 수 있도록 1로 초기화해놓기
			// 첨부파일이 없는 경우 게시글만 등록할 수 있도록 처리
			if(result>0 && at!=null) { // 게시글 등록이 성공했고 전달받은 첨부파일 정보가 있을 때
				// 첨부파일 정보 DB에 등록
				// 첨부파일이 어떠한 게시글에 등록된 첨부파일인지 알 수 있도록 참조게시글 번호 추가해주기
				at.setRefNno(noticeNo);
		
				result2 = new NoticeDao().insertAttachment(conn,at); // 첨부파일 등록이 되었는지 여부
				
				
				// result != 0 && result2 != 0 
			}
			
			// 게시글 등록 또는 게시글 + 첨부파일 등록 처리 후 
			// 트랜잭션처리하기
			if(result*result2>0) { // 둘다 0이 아닌 경우만 조건 통과
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			// 자원반납
			JDBCTemplate.close(conn);
			
			// 번호는 잘 뽑혔고 등록처리 후 결과값
			return result*result2;
			
		}else { // 게시글 번호부터 제대로 추출 안되었을때
			// 자원반납
			JDBCTemplate.close(conn);
			return noticeNo; // 등록처리하지 않고 되돌리기 boardNo 제대로 추출안되었으면 0으로 돌아옴
			
		}
	}
	
	
	//메인페이지 공지리스트
	public ArrayList<Notice> indexSelectNotice(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = new NoticeDao().indexSelectNotice(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	
	// 첨부파일 조회
	public Attachment selectAttachment(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		Attachment at  = new NoticeDao().selectAttachment(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return at;
	}


	public int deleteAttachment(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteAttachment(conn,noticeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	

}
