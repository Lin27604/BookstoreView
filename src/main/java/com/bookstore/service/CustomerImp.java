package com.bookstore.service;

import java.util.ArrayList;

import com.bookstore.entity.Cart;

public interface CustomerImp {
	
	public void viewBooks();
	public void search();
	public void addToCart(int id);
	public ArrayList<Cart> removebook(int id);
	public void purchase(int id);

}
