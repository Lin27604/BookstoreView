package com.bookstore.entity;

public class Cart {

	private String bookName;
	private double price;

	public Cart() {

		// TODO Auto-generated constructor stub
	}

	public Cart(String bookName, double price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [bookName=" + bookName + ", price=" + price + "]";
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
