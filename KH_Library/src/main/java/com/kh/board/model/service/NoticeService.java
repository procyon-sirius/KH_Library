package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.NoticeDao;
import com.kh.board.model.vo.Notice;
import com.kh.common.JDBCTemplate;

public class NoticeService {

	
	
	// 게시글 조회
	public ArrayList<Notice> selectNoticeList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
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
	
	
	
	
	
	
	

}
