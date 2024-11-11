package com.kh.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;

public class AdminService {

	public ArrayList<Book> searchBook(String category, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminDao().searchBook(conn,category, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Book> selectAllBook() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminDao().selectAllBook(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int statusChangeBook(int bookId, String status) {
		Connection conn = JDBCTemplate.getConnection();
		String changeStatus = "";
		
		if(status.equals("Y")) {
			changeStatus = "N";
		}else {
			changeStatus = "Y";
		}
		
		int result = new AdminDao().statusChangeBook(conn,bookId,changeStatus);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//체크 선택 삭제
	public int removeCkNBook(int bookId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		//카테고리 테이블에서 책정보 삭제
		int cRemove = new AdminDao().removeCkNCategory(conn, bookId);
		
		if(cRemove > 0) { //카테고리 정보 삭제 됐을시
			result = new AdminDao().removeCkNBook(conn, bookId);
		}
		
		if(cRemove * result > 0) { //둘중 하나라도 실패시 롤백
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int removeAllNBook() {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		//카테고리 테이블에서 책정보 삭제
		int cRemove = new AdminDao().removeAllNCategory(conn);
		if(cRemove > 0) { //카테고리 정보 삭제 됐을시
			result = new AdminDao().removeAllNBook(conn);
		}
		
		if(cRemove * result > 0) { //둘중 하나라도 실패시 롤백
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
