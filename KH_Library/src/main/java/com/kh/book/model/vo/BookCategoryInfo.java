package com.kh.book.model.vo;

public class BookCategoryInfo {
	private int categoryNo;// CATEGORY_NO NUMBER
	private String categoryName;// CATEGORY_NAME VARCHAR2(100 BYTE)

	public BookCategoryInfo() {
		super();
	}

	public BookCategoryInfo(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BookCategoryInfo [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}

}
