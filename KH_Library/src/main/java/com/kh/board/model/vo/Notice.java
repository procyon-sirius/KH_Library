package com.kh.board.model.vo;

import java.sql.Date;

public class Notice {
	
//	  NOTICE_NO NUMBER PRIMARY KEY,
//	  USER_NO NUMBER NOT NULL,
//	  NOTICE_TITLE VARCHAR2(100) NOT NULL,
//	  NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
//	  COUNT NUMBER DEFAULT 0,
//	  CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
//	  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')), 
//	  FOREIGN KEY(USER_NO) REFERENCES MEMBER(USER_NO)
	
	private int noticeNo;
	private int userNo;
	private String noticeTitle;
	private String noticeContent;
	private int number;
	private Date date;
	private String status;
	private String postPostion;
	
	
	public Notice() {
		super();
	}


	public Notice(int noticeNo, int userNo, String noticeTitle, int number, Date date) {
		super();
		this.noticeNo = noticeNo;
		this.userNo = userNo;
		this.noticeTitle = noticeTitle;
		this.number = number;
		this.date = date;
		
		
	}


	public Notice(int noticeNo, int userNo, String noticeTitle, String noticeContent, int number, Date date,
			String status) {
		super();
		this.noticeNo = noticeNo;
		this.userNo = userNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.number = number;
		this.date = date;
		this.status = status;
	}
	
	
	


	public Notice(int noticeNo, String noticeTitle, String postPostion) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.postPostion = postPostion;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
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

	
	

	public String getPostPostion() {
		return postPostion;
	}


	public void setPostPostion(String postPostion) {
		this.postPostion = postPostion;
	}


	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", userNo=" + userNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", number=" + number + ", date=" + date + ", status=" + status
				+ "]";
	}
	
	
	
	

}
