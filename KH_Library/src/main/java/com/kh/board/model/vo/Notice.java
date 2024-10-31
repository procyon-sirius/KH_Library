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
	
	
	

}
