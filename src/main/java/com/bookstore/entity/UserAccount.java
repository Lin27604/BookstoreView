package com.bookstore.entity;

import javax.lang.model.element.NestingKind;

public class UserAccount {
	private int Uid;
	private String name;
	private String age;
	private String userName;

	private String password;
	private String email;
	private String phone;
	



	



	public UserAccount() {
		
	}
	// Constructor with parameter
	public UserAccount(String name, String age, String userName, String password, String email, String phone) {
		
		this.name = name;
		this.age =age;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	public UserAccount(int uid, String name, String age, String userName, String password, String email, String phone
			) {
		super();
		Uid = uid;
		this.name = name;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
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

}
