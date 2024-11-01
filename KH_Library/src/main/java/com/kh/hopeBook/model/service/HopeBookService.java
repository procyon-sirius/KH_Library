package com.kh.hopeBook.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.dao.HopeBookDao;
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

	public ArrayList<HopeBook> selectHopeList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<HopeBook> list = new HopeBookDao().selectHopeList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public HopeBook hopeBookDetail(int hno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		HopeBook h = new HopeBookDao().hopeBookDetail(conn, hno);
		
		JDBCTemplate.close(conn);
		
		return h;
	}

}
