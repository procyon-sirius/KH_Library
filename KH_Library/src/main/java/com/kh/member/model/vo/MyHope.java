package com.kh.member.model.vo;

import java.sql.Date;

public class MyHope {
	
		private int hopeNum;//	HOPE_NUM	NUMBER
		private int hopeUser;//	HOPE_USER	NUMBER
		private String hopeTitle;//	HOPE_TITLE	VARCHAR2(100 BYTE)
		private String hopeAuthor;//	HOPE_AUTHOR	VARCHAR2(100 BYTE)
		private String hopeContent;//	HOPE_CONTENT	VARCHAR2(4000 BYTE)
		private Date hopeDate;//	HOPE_DATE	DATE
		private String hopePublic;//	HOPE_PUBLIC	VARCHAR2(1 BYTE)
		private String hopeState;//	HOPE_STATE	VARCHAR2(1 BYTE)
		private String userName;//USER_NAME	VARCHAR2(15 BYTE)
		
		public MyHope() {
			super();
		}
			
		public MyHope(String userName,String hopeTitle, Date hopeDate) {
			super();
			this.userName = userName;
			this.hopeTitle = hopeTitle;
			this.hopeDate = hopeDate;		
		}


		public MyHope(int hopeNum, int hopeUser, String hopeTitle, String hopeAuthor, String hopeContent, Date hopeDate,
				String hopePublic, String hopeState, String userName) {
			super();
			this.hopeNum = hopeNum;
			this.hopeUser = hopeUser;
			this.hopeTitle = hopeTitle;
			this.hopeAuthor = hopeAuthor;
			this.hopeContent = hopeContent;
			this.hopeDate = hopeDate;
			this.hopePublic = hopePublic;
			this.hopeState = hopeState;
			this.userName = userName;
		}

		public int getHopeNum() {
			return hopeNum;
		}

		public void setHopeNum(int hopeNum) {
			this.hopeNum = hopeNum;
		}

		public int getHopeUser() {
			return hopeUser;
		}

		public void setHopeUser(int hopeUser) {
			this.hopeUser = hopeUser;
		}

		public String getHopeTitle() {
			return hopeTitle;
		}

		public void setHopeTitle(String hopeTitle) {
			this.hopeTitle = hopeTitle;
		}

		public String getHopeAuthor() {
			return hopeAuthor;
		}

		public void setHopeAuthor(String hopeAuthor) {
			this.hopeAuthor = hopeAuthor;
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

		public String getHopeState() {
			return hopeState;
		}

		public void setHopeState(String hopeState) {
			this.hopeState = hopeState;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		@Override
		public String toString() {
			return "MyHope [hopeNum=" + hopeNum + ", hopeUser=" + hopeUser + ", hopeTitle=" + hopeTitle
					+ ", hopeAuthor=" + hopeAuthor + ", hopeContent=" + hopeContent + ", hopeDate=" + hopeDate
					+ ", hopePublic=" + hopePublic + ", hopeState=" + hopeState + ", userName=" + userName + "]";
		}
		
		
		
		
		

		
		
		
		
	
	

}
