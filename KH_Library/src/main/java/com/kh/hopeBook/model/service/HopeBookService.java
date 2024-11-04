package com.kh.hopeBook.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.dao.HopeBookDao;
import com.kh.hopeBook.model.vo.HopeBook;
import com.kh.hopeBook.model.vo.PageInfo;

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

	public ArrayList<HopeBook> selectHopeList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<HopeBook> list = new HopeBookDao().selectHopeList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public HopeBook hopeBookDetail(int hno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		HopeBook h = new HopeBookDao().hopeBookDetail(conn, hno);
		
		JDBCTemplate.close(conn);
		
		return h;
	}

	public int deleteHope(int hopeNum) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new HopeBookDao().deleteHope(conn, hopeNum);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public int listCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new HopeBookDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

}
