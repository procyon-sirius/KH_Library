package com.kh.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminBookDao;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.JDBCTemplate;

public class AdminBookService {

	public ArrayList<Book> searchBook(String category, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminBookDao().searchBook(conn,category, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Book> selectAllBook() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Book> list = new AdminBookDao().selectAllBook(conn);
		
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
		
		int result = new AdminBookDao().statusChangeBook(conn,bookId,changeStatus);
		
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
		int cRemove = new AdminBookDao().removeCkNCategory(conn, bookId);
		
		if(cRemove > 0) { //카테고리 정보 삭제 됐을시
			result = new AdminBookDao().removeCkNBook(conn, bookId);
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
		int cRemove = new AdminBookDao().removeAllNCategory(conn);
		if(cRemove > 0) { //카테고리 정보 삭제 됐을시
			result = new AdminBookDao().removeAllNBook(conn);
		}
		
		if(cRemove * result > 0) { //둘중 하나라도 실패시 롤백
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int bookCategoryDelete(String cno) {
		Connection conn = JDBCTemplate.getConnection();
		//카테고리가 여러개인 도서 : 도서에서 해당 카테고리 정보 삭제
		//delete
		new AdminBookDao().bookCategoryDelete(conn,cno);
		
		//카테고리가 한개뿐인 도서 : 도서의 카테고리 정보를 0(미지정)으로 변경
		//change
		new AdminBookDao().bookCategoryChangeZero(conn,cno);
		
		int result = 0;
		
		result = new AdminBookDao().bookCategoryInfoDelete(conn,cno);
		
		
		if(result> 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertNewBookCategoryInfo(BookCategoryInfo cInfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminBookDao().insertNewBookCategoryInfo(conn,cInfo);
		
		if(result> 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

}