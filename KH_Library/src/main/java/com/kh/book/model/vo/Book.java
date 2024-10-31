package com.kh.book.model.vo;

import java.sql.Date;

public class Book {
	private int bookId;// BOOK_ID NUMBER
	private String bookTitle;// BOOK_TITLE VARCHAR2(1000 BYTE)
	private String bookAuthor;// BOOK_AUTHOR VARCHAR2(100 BYTE)
	private String publisher;// PUBLISHER VARCHAR2(100 BYTE)
	private int publishDate;// PUBLISH_DATE NUMBER
	private Date enrollDate;// ENROLL_DATE DATE
	private String status;// STATUS VARCHAR2(1 BYTE)
	private String ageRank;// AGE_RANK VARCHAR2(1 BYTE)
	private int rentCount;// RENT_COUNT NUMBER

	public Book() {
		super();
	}

	public Book(int bookId, String bookTitle, String bookAuthor, String publisher, int publishDate, Date enrollDate,
			String status, String ageRank, int rentCount) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.enrollDate = enrollDate;
		this.status = status;
		this.ageRank = ageRank;
		this.rentCount = rentCount;
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

	public int getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(int publishDate) {
		this.publishDate = publishDate;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgeRank() {
		return ageRank;
	}

	public void setAgeRank(String ageRank) {
		this.ageRank = ageRank;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", publisher="
				+ publisher + ", publishDate=" + publishDate + ", enrollDate=" + enrollDate + ", status=" + status
				+ ", ageRank=" + ageRank + ", rentCount=" + rentCount + "]";
	}

}
