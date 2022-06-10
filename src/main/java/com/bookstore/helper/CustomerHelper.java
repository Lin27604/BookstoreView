package com.bookstore.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
				//book.setPrice( rst.getString("price"));
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
//	public ArrayList<Cart> addToCart(int id) {
//		sql= "SELECT title, price FROM book WHERE idBook = ?";
//		ArrayList<Cart> carts = new ArrayList<Cart>();
//		try {
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, id);
//			ResultSet rs = daoImp.selectData(psmt);
//			while(rs.next()) {
//				
//				carts.add(new Cart(rs.getString("title"),rs.getString("price") ));
//				
//				
//				shoppingCart.setBookName(rs.getString("title"));
//				shoppingCart.setPrice(rs.getDouble("price"));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return carts;
//		
//	}
	
	//Error
	
//	public int insertIntoHistory(int id) {
//		int insertRow= 0;
//		sql = "INSERT INTO history(buyer, book, price) SELECT title, price from book WHERE idBook=?" +" and buyer =? " ;
//		try {
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, id);
//		    psmt.setString(2, CacheMemory.loggedUsername);
//			insertRow = daoImp.insertData(psmt);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return insertRow;
//		
//	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    sql = "select * from book where id=?";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.setInt(1, item.getId());
                    ResultSet rst = daoImp.selectData(psmt);
                    while (rst.next()) {
                        Cart row = new Cart();
                        row.setId(rst.getInt("id"));
                        row.setTitle(rst.getString("title"));
                        row.setPrice(Double.parseDouble(rst.getString("price"))*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    sql = "select price from book where id=?";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.setInt(1, item.getId());
                    ResultSet rst = daoImp.selectData(psmt);
                    while (rst.next()) {
                        sum+=Double.parseDouble(rst.getString("price"))*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	


public boolean insertmessage(String name, String email, String comment, String date) {
	
	sql = "INSERT INTO message(name,email, comment, date) VALUES (?,?,?,?)";
	boolean result = false;
	try {
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, email);
		psmt.setString(3, comment);
		psmt.setString(4, date);
		daoImp.updateData(psmt);
		result = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result;
	
}
public void getMessage() {
	sql = "select * from message";
	PreparedStatement psmt;
	try {
		psmt = conn.prepareStatement(sql);
		ResultSet rst = daoImp.selectData(psmt);
		while (rst.next()) {
			rst.getString("name");
			rst.getString("email");
			rst.getString("Comment");
			rst.getString("date");
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
}


}