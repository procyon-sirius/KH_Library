package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.QnADao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class QnAService {
	
	
	// 조회수 증가
	public int increaseCount(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new QnADao().increaseCount(conn,bno);
	
		
		if(listCount>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	
	
	// Q 리스트 조회 
	public ArrayList<Board> selectQList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> b = new QnADao().selectQList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	

	// R 리스트 조회
	public ArrayList<Reply> selectAList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reply> r = new QnADao().selectRList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		
		return r;
	}


	
	// 게시글 작성
	public int insertQnA(String title, String content, int userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new QnADao().insertQnA(conn,title,content,userId);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
	

}
