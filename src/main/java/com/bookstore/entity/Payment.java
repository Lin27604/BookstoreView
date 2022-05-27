package com.bookstore.entity;

public class Payment {
	private String name;
	private String cardNumber;
	private String date;
	private String validCode;
	private String address;
	public Payment(String name, String cardNumber, String date, String validCode, String address) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.date = date;
		this.validCode = validCode;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setNameg(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
