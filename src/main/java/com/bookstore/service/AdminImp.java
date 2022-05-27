package com.bookstore.service;

import com.bookstore.entity.Book;

public interface AdminImp {
	
	public void display();
	
	public int delete(int id);
	public int edit(int id,Double price);
	public void purchaseHistory();
	public int insert(Book book);

;
	

}
