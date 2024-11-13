package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.CommentDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class CommentService {
	
	
	// 게시글 수 조회
	public int listCount() {
		Connection conn = JDBCTemplate.getConnection();
		int listCount = new CommentDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	
	// 책 목록 조회
	public ArrayList<Book> selectCommentList(PageInfo pi) {
	
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> list = new CommentDao().selectCommentList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}


	
	// 책 내용 조회
	public Book selectBookForComment(int bno) {

		Connection conn = JDBCTemplate.getConnection();
		Book b = new CommentDao().selectBookForComment(conn,bno);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	
	// 게시글 만들기
	public int createComment(int bookNo, int writerNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int b = new CommentDao().createComment(conn,bookNo,writerNo);
		JDBCTemplate.close(conn);
		return b;
	}

	
	// 게시글 유무 체크
	public int selectClist(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		int boardN = new CommentDao().selectClist(conn,bookNo);
		JDBCTemplate.close(conn);
		
		return boardN;
	}

	
	// 코멘트 생성
	public int createReply(int boardN, int writerNo, String comment) {
		Connection conn = JDBCTemplate.getConnection();
		int commentR = new CommentDao().createReply(conn,boardN,writerNo,comment);
		JDBCTemplate.close(conn);
		
		return commentR;
	}

	
	// 코멘트 조회
	public ArrayList<Reply> selectReply(int bno) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reply> rlist = new CommentDao().selectReply(conn,bno);
		
		JDBCTemplate.close(conn);
		
		return rlist;
	}


	public int replyCount(int boardN) {
		Connection conn = JDBCTemplate.getConnection();
		int rCount = new CommentDao().replyCount(conn,boardN);
		JDBCTemplate.close(conn);
		
		return rCount;
	}



}