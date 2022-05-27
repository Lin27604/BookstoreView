package com.bookstore.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bookstore.entity.Cart;
import com.bookstore.entity.Book;
import com.bookstore.model.CacheMemory;
import com.bookstore.model.DAOImp;

public class CustomerHelper {
	
	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();
	Book book = new Book();
	Scanner scanner = new Scanner(System.in);
	String sql= null;
	Cart shoppingCart = new Cart();
	public Book searchbook() {
		sql = "SELECT * FROM book WHERE category = ? OR title =? ";
		System.out.println("Enter category or book title to search: ");
		String searchBook = scanner.next();
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, searchBook);
			psmt.setString(2, searchBook);
			ResultSet rst = daoImp.selectData(psmt);
			
			while(rst.next()) {
				int id = rst.getInt("idBook");
				book.setCategory(rst.getString("category"));
				book.setTitle(rst.getString("title"));
				book.setAuthor(rst.getString("author"));
				book.setISBN( rst.getString("ISBN"));
				book.setPublisher( rst.getString("publisher"));
				book.setEditionNumber(rst.getString("editionNumber"));
				book.setPrice( rst.getDouble("price"));
			System.out.println(id +" "+book.toString());
				//				System.out.println("Category"+ " " +" Title" + " " + "Author" + " " + "ISBN" + " " +"Publiher" + " "
//						+ "Edition"+ " " + "Price");
//				System.out.println(category+ " " + title + " " + author + " " + ISBN + " " +publiher + " "
//				+ edition+ " " + price);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	//Add the book to shopping cart
	public ArrayList<Cart> addToCart(int id) {
		sql= "SELECT title, price FROM book WHERE idBook = ?";
		ArrayList<Cart> carts = new ArrayList<Cart>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = daoImp.selectData(psmt);
			while(rs.next()) {
				
				carts.add(new Cart(rs.getString("title"),rs.getDouble("price") ));
				
				
//				shoppingCart.setBookName(rs.getString("title"));
//				shoppingCart.setPrice(rs.getDouble("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
		
	}
	
	//Error
	
	public int insertIntoHistory(int id) {
		int insertRow= 0;
		sql = "INSERT INTO history(buyer, book, price) SELECT title, price from book WHERE idBook=?" +" and buyer =? " ;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
		    psmt.setString(2, CacheMemory.loggedUsername);
			insertRow = daoImp.insertData(psmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertRow;
		
	}

}
