package com.kh.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.board.model.dao.NoticeDao;
import com.kh.board.model.dao.ReplyDao;
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
		
		return result;

	}
	
}
	
	


