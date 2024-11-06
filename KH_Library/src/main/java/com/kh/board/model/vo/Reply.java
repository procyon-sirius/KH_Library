package com.kh.board.model.vo;

import java.sql.Date;

public class Reply {

//	  BOARD_NO NUMBER PRIMARY KEY,
//	  USER_NO NUMBER NOT NULL,
//	  REPLY_CONTENT VARCHAR2(400) NOT NULL, 
//	  CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
//	  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
	
	
	private int boardNo; 
	private String userNo; 
	private String replyContent; 
	private Date date;
	private String status;
	
	
	
	public Reply() {
		
	}



	public Reply(int boardNo, String userNo, String replyContent, Date date, String status) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.replyContent = replyContent;
		this.date = date;
		this.status = status;
	}

	
	
	
	
	public Reply(int boardNo, String userNo, String replyContent, Date date) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.replyContent = replyContent;
		this.date = date;
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public String getUserNo() {
		return userNo;
	}



	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Reply [boardNo=" + boardNo + ", userNo=" + userNo + ", replyContent=" + replyContent + ", date=" + date
				+ ", status=" + status + "]";
	}
	
	
}
