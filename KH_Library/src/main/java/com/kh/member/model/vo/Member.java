package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	private int userNo; // USER_NO NUMBER
	private String userId; // USER_ID VARCHAR2(30)
	private String userPwd; // USER_PWD VARCHAR2(100)
	private String userName;// USER_NAME VARCHAR2(15)
	private String userNno; // USER_NNO CHAR(14)
	private String phone; // PHONE VARCHAR2(13)
	private String email; // EMAIL VARCHAR2(100)
	private String address; // ADDRESS VARCHAR2(100)
	private Date enrollDate;// ENROLL_DATE DATE
	private Date modifyDate;// MODIFY_DATE DATE
	private int rentLimit;
	private String status; // STATUS VARCHAR2(1)

	public Member() {
		super();
	}
	
	

	public Member(int userNo, String userId, String userName, int rentLimit) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.rentLimit = rentLimit;
	}



	public Member(String userId, String userName, String phone, String email, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Member(String userId, String userPwd, String userName, String userNno, String phone, String email,
			String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNno = userNno;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String userNno, String phone,
			String email, String address, Date enrollDate, Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNno = userNno;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String userNno, String phone,
			String email, String address, Date enrollDate, Date modifyDate, int rentLimit, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNno = userNno;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.rentLimit = rentLimit;
		this.status = status;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNno() {
		return userNno;
	}

	public void setUserNno(String userNno) {
		this.userNno = userNno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getenrollDate() {
		return enrollDate;
	}

	public void setenrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getRentLimit() {
		return rentLimit;
	}

	public void setRentLimit(int rentLimit) {
		this.rentLimit = rentLimit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userNno=" + userNno + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", rentLimit=" + rentLimit + ", status="
				+ status + "]";
	}

}
