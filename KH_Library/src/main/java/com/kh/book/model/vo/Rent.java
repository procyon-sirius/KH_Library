package com.kh.book.model.vo;

import java.sql.Date;

public class Rent {
	private int bookId;// BOOK_ID NUMBER
	private Date returnDate;// RETURN_DATE DATE
	private int userNo;// USER_NO NUMBER

	public Rent() {
		super();
	}

	public Rent(int bookId, Date returnDate, int userNo) {
		super();
		this.bookId = bookId;
		this.returnDate = returnDate;
		this.userNo = userNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Rent [bookId=" + bookId + ", returnDate=" + returnDate + ", userNo=" + userNo + "]";
	}

}
