package com.kh.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.board.model.dao.NoticeDao;
import com.kh.board.model.dao.QnADao;
import com.kh.board.model.dao.ReplyDao;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;

public class ReplyService {

	
	// 문의글 답변 생성 메소드
	public int insertReply(String content, int boardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ReplyDao().insertReply(conn,content,boardNo);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	// 답변 수정하기 
	public int updateReply(String content, int boardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ReplyDao().updateReply(conn,content,boardNo);
	
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	// 답변 삭제하기
	public int deleteReply(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ReplyDao().deleteReply(conn,noticeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;

	}

	
	
// ------------------------> 자유게시판 ------------------------------
	
	// 자유게시판 댓글 생성 메소드
	public int insertFBReply(String content, int boardNo, int writerNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ReplyDao().insertFBReply(conn,content,boardNo,writerNo);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	// 댓글 리스트 조회
	public ArrayList<Reply> selectFBreplyList(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reply> r = new ReplyDao().selectFBreplyList(conn,nno);
		
		JDBCTemplate.close(conn);
		
		
		return r;
	}

	
	// 댓글 조회
	public Reply selectFBreply(int replyNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		Reply r = new ReplyDao().selectFBreply(conn,replyNo);
		
		JDBCTemplate.close(conn);
		
		return r;
	}

	
	// 댓글 삭제
	public int deletefbReply(int replyNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ReplyDao().deletefbReply(conn,replyNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}
	
	


