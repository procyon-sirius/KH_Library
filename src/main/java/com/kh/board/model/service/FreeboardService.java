package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.FreeBoardDao;
import com.kh.board.model.dao.NoticeDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Notice;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class FreeboardService {
	
	
	
	// 게시글 수 조회
	public int listCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new FreeBoardDao().listCount(conn);
		
		
		if(listCount>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	// 게시글 목록 조회
	public ArrayList<Board> selectFreeboardList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> freeBoard = new FreeBoardDao().selectFreeboardList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return freeBoard;
	}
	
	
	// 조회 수 증가
	public int increaseCount(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new FreeBoardDao().increaseCount(conn,nno);
		
		
		if(listCount>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	
	
	// 게시글 상세조회
	public Board selectFreeBoard(int nno) {
		Connection conn = JDBCTemplate.getConnection();
		Board freeBoard = new FreeBoardDao().selectFreeBoard(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return freeBoard;
	}
	
	
	
	// 이전글 다음글 조회
	public ArrayList<Board> preNnext(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> preNnext = new FreeBoardDao().preNnext(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return preNnext;

	}
	
	
	
	// 게시글 작성
	public int insertFreeboard(String title, String content, int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeBoardDao().insertFreeboard(conn,title,content,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	// 게시글 수정
	public int updateFreeBoard(String title, String content, int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeBoardDao().updateFreeBoard(conn,title,content,nno);
	
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	// 게시글 삭제
	
	public int deleteFreeBoard(int boardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new FreeBoardDao().deleteFreeBoard(conn,boardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	

}
