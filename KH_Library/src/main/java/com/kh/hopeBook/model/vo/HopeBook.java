package com.kh.hopeBook.model.vo;

import java.sql.Date;

public class HopeBook {
	private int hopeNum;//	HOPE_NUM	NUMBER '게시글 번호'
	private String hopeUser;//	HOPE_USER	NUMBER '유저 번호(아이디)'
	private String hopeTitle;//	HOPE_TITLE	VARCHAR2(100 BYTE) '책 제목'
	private String hopeAutor;//	HOPE_AUTHOR	VARCHAR2(100 BYTE) '책 저자'
	private String hopeContent;//	HOPE_CONTENT	VARCHAR2(4000 BYTE) '신청 이유'
	private Date hopeDate;//	HOPE_DATE	DATE
	private String hopePublic;//	HOPE_PUBLIC	VARCHAR2(1 BYTE) 
	private String hopeStatus;//	HOPE_STATE	VARCHAR2(1 BYTE)
	
	public HopeBook() {
		super();
	}

	public HopeBook(int hopeNum, String hopeUser, String hopeTitle, String hopeAutor, String hopeContent, Date hopeDate,
			String hopePublic, String hopeStatus) {
		super();
		this.hopeNum = hopeNum;
		this.hopeUser = hopeUser;
		this.hopeTitle = hopeTitle;
		this.hopeAutor = hopeAutor;
		this.hopeContent = hopeContent;
		this.hopeDate = hopeDate;
		this.hopePublic = hopePublic;
		this.hopeStatus = hopeStatus;
	}

	public int getHopeNum() {
		return hopeNum;
	}

	public void setHopeNum(int hopeNum) {
		this.hopeNum = hopeNum;
	}

	public String getHopeUser() {
		return hopeUser;
	}

	public void setHopeUser(String hopeUser) {
		this.hopeUser = hopeUser;
	}

	public String getHopeTitle() {
		return hopeTitle;
	}

	public void setHopeTitle(String hopeTitle) {
		this.hopeTitle = hopeTitle;
	}

	public String getHopeAutor() {
		return hopeAutor;
	}

	public void setHopeAutor(String hopeAutor) {
		this.hopeAutor = hopeAutor;
	}

	public String getHopeContent() {
		return hopeContent;
	}

	public void setHopeContent(String hopeContent) {
		this.hopeContent = hopeContent;
	}

	public Date getHopeDate() {
		return hopeDate;
	}

	public void setHopeDate(Date hopeDate) {
		this.hopeDate = hopeDate;
	}

	public String getHopePublic() {
		return hopePublic;
	}

	public void setHopePublic(String hopePublic) {
		this.hopePublic = hopePublic;
	}

	public String getHopeStatus() {
		return hopeStatus;
	}

	public void setHopeStatus(String hopeStatus) {
		this.hopeStatus = hopeStatus;
	}

	@Override
	public String toString() {
		return "HopeBook [hopeNum=" + hopeNum + ", hopeUser=" + hopeUser + ", hopeTitle=" + hopeTitle + ", hopeAutor="
				+ hopeAutor + ", hopeContent=" + hopeContent + ", hopeDate=" + hopeDate + ", hopePublic=" + hopePublic
				+ ", hopeStatus=" + hopeStatus + "]";
	}
}
