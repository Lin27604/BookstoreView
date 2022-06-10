package com.bookstore.service;

import java.util.ArrayList;

import com.bookstore.entity.Book;

public interface AdminImp {
	
	public String display();
	
	public int delete(int id);
	public void edit(int id, String category, String title, String author, String ISBN, String publisher, String editionNumber, String price );
	public void purchaseHistory();
	public int insert(Book book);

;
	

}
