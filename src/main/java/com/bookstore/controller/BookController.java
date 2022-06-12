package com.bookstore.controller;

import java.util.Scanner;

import com.bookstore.entity.Book;
import com.bookstore.helper.BookHelper;

public class BookController {

	BookHelper helper = new BookHelper();
	Scanner scanner = new Scanner(System.in);
	String result = "";

	public boolean insertBook(String category, String title, String author, String ISBN, String publisher,
			String Edition, String price) {
		Book book = new Book();
		book.setCategory(category);
		book.setTitle(title);
		book.setAuthor(author);
		book.setISBN(ISBN);
		book.setPublisher(publisher);
		book.setEditionNumber(Edition);
		book.setPrice(price);

		if (helper.insert(book) > 0) {
			return true;

		} else {
			return false;
		}
	

	}

	public String deleteBook(int id) {

		if (helper.delete(id) > 0) {
			result = "Delete successfully";

		} else {
			result = "failed to delete the record";
		}

		return result;

	}

//	public String editBook(int id, Double price) {
//
//		if (helper.edit(id, price) > 0) {
//			result = "Update successfully...";
//
//		} else {
//			result = "Failed to Update the price.";
//
//		}
//		return result;
//	}
//
}
