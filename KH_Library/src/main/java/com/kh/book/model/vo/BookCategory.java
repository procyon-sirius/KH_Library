package com.kh.book.model.vo;

public class BookCategory {
	private int bookId;// BOOK_ID NUMBER
	private int categoryNo;// CATEGORY_NO NUMBER

	public BookCategory() {
		super();
	}

	public BookCategory(int bookId, int categoryNo) {
		super();
		this.bookId = bookId;
		this.categoryNo = categoryNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "BookCategory [bookId=" + bookId + ", categoryNo=" + categoryNo + "]";
	}

}
