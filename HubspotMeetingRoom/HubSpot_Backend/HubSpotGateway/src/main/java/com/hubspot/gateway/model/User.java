package com.hubspot.gateway.model;

public class User {
	private int uId;
	private String companyName;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String password;
	private int age;
	private String gender;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uId, String companyName, String email, String firstName, String lastName, String mobileNumber,
			String password, int age, String gender) {
		super();
		this.uId = uId;
		this.companyName = companyName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", companyName=" + companyName + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", password=" + password + ", age="
				+ age + ", gender=" + gender + "]";
	}
	
	
}
