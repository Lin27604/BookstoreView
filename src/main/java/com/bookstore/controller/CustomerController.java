package com.bookstore.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.helper.BookHelper;
import com.bookstore.helper.CustomerHelper;
import com.bookstore.service.CustomerImp;

public class CustomerController implements CustomerImp{

	CustomerHelper cHelper = new CustomerHelper();
	ArrayList<Cart> carts = new ArrayList<Cart>();
	@Override
	public void viewBooks() {
		BookHelper bHelper = new BookHelper();
		bHelper.display();
//		Book book1 = new Book("Computer","Java","John Lee","123456751","ddk","2","$13");
//		
//	    ArrayList<Book> books = new ArrayList<Book>();
//	    books.add(book1);
//	    System.out.println(books);
		
	}

	@Override
	public void search() {
		cHelper.searchbook();
		
	}

	@Override
	public void addToCart(int id) {
	
		carts=cHelper.addToCart(id);
		
		//int sum=0;
		//for (int i= 0; i<carts.size();i++) {
			
			
		//}
		if (carts !=null) {
		    for (Cart cart : carts) {
		    	
		    	System.out.println(carts.toString());
			}
			
			System.out.println("Book added to cart");
			
		}else
			System.out.println("Failed to added to cart");
	
		
		
	}

	@Override
	public ArrayList<Cart> removebook(int id) {
		// TODO Auto-generated method stub
		
		
		for (Cart cart : carts) {
			carts.remove(cart);
			
		}
		System.out.println(carts);
		return carts;
			
		
	}

	@Override
	public void purchase(int id) {
		if(cHelper.insertIntoHistory(id)> 0) {
			System.out.println("Insert into purchase history successfully.");
		}
		else {
			System.out.println("failed to insert...");
		}
	}





}
