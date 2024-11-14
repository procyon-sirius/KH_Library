package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.NoticeDao;
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
	public int insertNotice(String title, String content) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn,title,content);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	//메인페이지 공지리스트
	public ArrayList<Notice> indexSelectNotice(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = new NoticeDao().indexSelectNotice(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	

}
