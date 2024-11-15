package com.kh.book.model.vo;

public class Reserve {
	private int bookId;// BOOK_ID NUMBER
	private int userNo;// USER_NO NUMBER
	private String returnBook;// RETURN_BOOK VARCHAR2(1 BYTE)

	public Reserve() {
		super();
	}

	public Reserve(int bookId, int userNo, String returnBook) {
		super();
		this.bookId = bookId;
		this.userNo = userNo;
		this.returnBook = returnBook;
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

	public String getReturnBook() {
		return returnBook;
	}

	public void setReturnBook(String returnBook) {
		this.returnBook = returnBook;
	}

	@Override
	public String toString() {
		return "Reserve [bookId=" + bookId + ", userNo=" + userNo + ", returnBook=" + returnBook + "]";
	}

}
