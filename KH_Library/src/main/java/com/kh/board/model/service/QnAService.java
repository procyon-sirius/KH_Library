package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.QnADao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;

public class QnAService {
	
	
	// 조회수 증가
	public int increaseCount(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new QnADao().increaseCount(conn,bno);
		JDBCTemplate.close(conn);
		
		if(listCount>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return listCount;
	}
	
	
	
	// Q 리스트 조회 
	public ArrayList<Board> selectQList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> b = new QnADao().selectQList(conn);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	

	// R 리스트 조회
	public ArrayList<Reply> selectAList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reply> r = new QnADao().selectRList(conn);
		
		JDBCTemplate.close(conn);
		
		
		return r;
	}

}
