package com.kh.board.model.vo;

public class Reply {

//	  BOARD_NO NUMBER PRIMARY KEY,
//	  USER_NO NUMBER NOT NULL,
//	  REPLY_CONTENT VARCHAR2(400) NOT NULL, 
//	  CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
//	  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
	
	
	private int boardNo; 
	private int userNo; 
	private String replyContent; 
	private int date;
	private String status;
	
}
