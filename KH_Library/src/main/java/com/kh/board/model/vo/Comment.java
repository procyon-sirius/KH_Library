package com.kh.board.model.vo;

public class Comment {
	private String userName;
	private String userId;
	private String bookTitle;
	private String replyComment;
	private String imgName;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(String userName, String userId, String bookTitle, String replyComment, String imgName) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.bookTitle = bookTitle;
		this.replyComment = replyComment;
		this.imgName = imgName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "Comment [userName=" + userName + ", userId=" + userId + ", bookTitle=" + bookTitle + ", replyComment="
				+ replyComment + ", imgName=" + imgName + "]";
	}
	
	
	
}
