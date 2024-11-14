package com.kh.board.model.vo;

import java.sql.Date;

public class Attachment {
	
//	FILE_NO	NUMBER
//	REF_NNO	NUMBER
//	ORIGIN_NAME	VARCHAR2(255 BYTE)
//	CHANGE_NAME	VARCHAR2(255 BYTE)
//	FILE_PATH	VARCHAR2(1000 BYTE)
//	STATUS	VARCHAR2(1 BYTE)
	
	
	private int fileNo;
	private int refNno;
	private String originName;
	private String changeName;
	private String filePath;
	private String status;
	
	
	public Attachment() {
		super();
	}
	

	public Attachment(int fileNo, int refNno, String originName, String changeName, String filePath, String status) {
		super();
		this.fileNo = fileNo;
		this.refNno = refNno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.status = status;
	}


	
	public Attachment(int fileNo, String originName, String changeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}


	public int getFileNo() {
		return fileNo;
	}



	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}



	public int getRefNno() {
		return refNno;
	}



	public void setRefNno(int refNno) {
		this.refNno = refNno;
	}



	public String getOriginName() {
		return originName;
	}



	public void setOriginName(String originName) {
		this.originName = originName;
	}



	public String getChangeName() {
		return changeName;
	}



	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}



	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


}
