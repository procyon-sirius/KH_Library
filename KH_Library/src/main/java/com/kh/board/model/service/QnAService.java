package com.kh.board.model.service;

import java.sql.Connection;

import com.kh.board.model.dao.QnADao;
import com.kh.common.JDBCTemplate;

public class QnAService {
	
	
	// 조회수 증가
	public int listCount(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new QnADao().listCount(conn);
		JDBCTemplate.close(conn);
		
		return listCount;
	}

}
