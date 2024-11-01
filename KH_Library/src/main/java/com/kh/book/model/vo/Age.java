package com.kh.book.model.vo;

public class Age {
	private int ageRank;// AGE_RANK VARCHAR2(1 BYTE)
	private String age;// AGE VARCHAR2(30 BYTE)

	public Age() {
		super();
	}

	public Age(int ageRank, String age) {
		super();
		this.ageRank = ageRank;
		this.age = age;
	}

	public int getAgeRank() {
		return ageRank;
	}

	public void setAgeRank(int ageRank) {
		this.ageRank = ageRank;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Age [ageRank=" + ageRank + ", age=" + age + "]";
	}

}
