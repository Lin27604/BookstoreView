package com.bookstore.entity;

import javax.lang.model.element.NestingKind;

public class UserAccount {
	
	private String name;
	private String age;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String address;



	



	public UserAccount() {
		
	}
	// Constructor with parameter
	public UserAccount(String name, String age, String userName, String password, String email, String phone, String address) {
		
		this.name = name;
		this.age =age;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
