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
	private String userNo; 
	private int userNo_Int;
	private int bookId; 
	private String boardTitle; 
	private String boardContent; 
	private Date date; 
	private int count; 
	private String status;
	private String position;
	
	
	
	public Board() {
		super();
	}



	public Board(int boardNo, int boardTypeNo, String userNo, int bookId, String boardTitle, String boardContent,
			Date date, int count, String status) {
		super();
		this.boardNo = boardNo;
		this.boardTypeNo = boardTypeNo;
		this.userNo = userNo;
		this.bookId = bookId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.date = date;
		this.count = count;
		this.status = status;
	}

	
	

	public Board(int boardNo, int boardTypeNo, String userNo, String boardTitle, String boardContent, Date date,
			int count) {
		super();
		this.boardNo = boardNo;
		this.boardTypeNo = boardTypeNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.date = date;
		this.count = count;
	}

	
	

	public Board(int boardNo, String userNo, String boardTitle, Date date, int count) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.date = date;
		this.count = count;
	}


	public Board(int boardNo, String userNo, int userNo_Int, String boardTitle, String boardContent, Date date,
			int count) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.userNo_Int = userNo_Int;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.date = date;
		this.count = count;
	}



	public Board(int boardNo, String boardTitle, Date date, String position) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.date = date;
		this.position = position;
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public int getBoardTypeNo() {
		return boardTypeNo;
	}



	public void setBoardTypeNo(int boardTypeNo) {
		this.boardTypeNo = boardTypeNo;
	}



	public String getUserNo() {
		return userNo;
	}



	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getBoardContent() {
		return boardContent;
	}



	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	
	

	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public int getUserNo_Int() {
		return userNo_Int;
	}



	public void setUserNo_Int(int userNo_Int) {
		this.userNo_Int = userNo_Int;
	}



	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTypeNo=" + boardTypeNo + ", userNo=" + userNo + ", bookId="
				+ bookId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", date=" + date
				+ ", count=" + count + ", status=" + status + "]";
	} 
	
	
	
	
}
