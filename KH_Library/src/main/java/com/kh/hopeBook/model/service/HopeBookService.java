package com.kh.hopeBook.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.hopeBook.model.dao.HopeBookDao;
import com.kh.hopeBook.model.vo.HopeBook;
import com.kh.hopeBook.model.vo.PageInfo;

public class HopeBookService {

	//책 신청
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

	//신청 현황 리스트 뽑기
	public ArrayList<HopeBook> selectHopeList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<HopeBook> list = new HopeBookDao().selectHopeList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}


	public ArrayList<HopeBook> selectHopeListDESC(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<HopeBook> list = new HopeBookDao().selectHopeListDESC(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	
	//상세보기
	public HopeBook hopeBookDetail(int hopeNum) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		HopeBook h = new HopeBookDao().hopeBookDetail(conn, hopeNum);
		
		JDBCTemplate.close(conn);
		
		return h;
	}

	//게시글 삭제
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

	//신청확인(관리자)
	public int hopeCheck(int hopeNum) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new HopeBookDao().hopeCheck(conn, hopeNum);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
