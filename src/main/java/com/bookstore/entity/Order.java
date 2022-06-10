package com.bookstore.entity;

public class Order extends Book{
	
	private String user;
	private int bid;
	private int qunatity;
	private String status;
	private String date;
	
	public Order() {
		
	}

	public Order(String user, int bid, int qunatity, String status, String date) {
		super();
		this.user = user;
		this.bid = bid;
		this.qunatity = qunatity;
		this.status = status;
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}