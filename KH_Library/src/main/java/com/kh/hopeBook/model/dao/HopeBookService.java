package com.kh.hopeBook.model.dao;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.service.HopeBookDao;
import com.kh.hopeBook.model.vo.HopeBook;

public class HopeBookService {

	public int hopeBookInsert(HopeBook h) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new HopeBookDao().hopeBookInsert(conn, h);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
