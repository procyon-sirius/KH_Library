package com.kh.book.model.vo;

public class Reserve {
	private int bookId;// BOOK_ID NUMBER
	private int userNo;// USER_NO NUMBER

	public Reserve() {
		super();
	}

	public Reserve(int bookId, int userNo) {
		super();
		this.bookId = bookId;
		this.userNo = userNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Reserve [bookId=" + bookId + ", userNo=" + userNo + "]";
	}

}
