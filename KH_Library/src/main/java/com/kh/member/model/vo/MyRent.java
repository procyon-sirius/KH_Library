package com.kh.member.model.vo;

import java.sql.Date;

public class MyRent {
	
	private int bookId; //	BOOK_ID	NUMBER
	private String bookTitle;  //	BOOK_TITLE	VARCHAR2(1000 BYTE)
	private String bookAuthor; //	BOOK_AUTHOR	VARCHAR2(100 BYTE)
	private String publisher;  //	PUBLISHER	VARCHAR2(100 BYTE)
	private Date returnDate; //	RETURN_DATE	DATE
	private String returnDelay; //	RETURN_DELAY	VARCHAR2(1 BYTE)
	private int userNo; //	USER_NO	NUMBER
	private String status;	// STATUS VARCHAR2(1 BYTE)
	
	public MyRent() {
		super();
	}
	
	public MyRent(int bookId, String bookTitle, String bookAuthor, String publisher) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
	}


	public MyRent(int bookId, String bookTitle, String bookAuthor, String publisher, Date returnDate) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.returnDate = returnDate;
	}

	

	public MyRent(int bookId, String bookTitle, String bookAuthor, String publisher, Date returnDate,
			String returnDelay, int userNo, String status) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.returnDate = returnDate;
		this.returnDelay = returnDelay;
		this.userNo = userNo;
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnDelay() {
		return returnDelay;
	}

	public void setReturnDelay(String returnDelay) {
		this.returnDelay = returnDelay;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MyRent [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", publisher="
				+ publisher + ", returnDate=" + returnDate + ", returnDelay=" + returnDelay + ", userNo=" + userNo
				+ ", status=" + status + "]";
	}
	

	
	

}
