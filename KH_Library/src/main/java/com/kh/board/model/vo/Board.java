package com.kh.board.model.vo;

import java.sql.Date;

public class Board {
	
//	  BOARD_NO NUMBER PRIMARY KEY,
//	  BOARD_TYPE_NO NUMBER NOT NULL,
//	  USER_NO NUMBER NOT NULL,
//	  BOOK_ID NUMBER NOT NULL,
//	  BOARD_TITLE VARCHAR2(100) NOT NULL,
//	  BOARD_CONTENT VARCHAR2(4000) NOT NULL, 
//	  CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
//	  COUNT NUMBER DEFAULT 0,
//	  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
//	  FOREIGN KEY (BOARD_TYPE_NO) REFERENCES BOARD(BOARD_TYPE_NO),
//	  FOREIGN KEY (USER_NO) REFERENCES MEMBER(USER_NO),
//	  FOREIGN KEY (BOOK_ID) REFERENCES BOOK (BOOK_ID) 
	
	private int boardNo; 
	private int boardTypeNo; 
	private int userNo; 
	private int bookId; 
	private String boardTitle; 
	private String boardContent; 
	private Date date; 
	private int count; 
	private String status; 
	
	
	
}
