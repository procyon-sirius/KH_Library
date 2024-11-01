package com.kh.book.model.vo;

import java.sql.Date;

public class Recommend {
	private int bookId;// BOOK_ID NUMBER
	private Date rDate;// R_DATE DATE

	public Recommend() {
		super();
	}

	public Recommend(int bookId, Date rDate) {
		super();
		this.bookId = bookId;
		this.rDate = rDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "Recommend [bookId=" + bookId + ", rDate=" + rDate + "]";
	}

}
