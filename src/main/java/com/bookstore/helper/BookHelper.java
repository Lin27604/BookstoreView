package com.bookstore.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookstore.entity.Book;
import com.bookstore.model.DAOImp;


import com.bookstore.service.AdminImp;

public class BookHelper implements AdminImp {
	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();
	Book book = new Book();
	String sql = null;
	String result = "";
	ArrayList<Book> books = new ArrayList<Book>();
	@Override
	public String display() {
		sql = "SELECT category, title, author, ISBN, publisher,editionNumber, price FROM book";
		
		String result ="<div class=\"tbl-content\">\n";
		result += "<table class=\"books\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n";
	//	String message = "Can't get data from database";
		try {
		
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rst = daoImp.selectData(psmt);
			ResultSetMetaData rsmd = rst.getMetaData();
			int count = rsmd.getColumnCount();
			result += "<tr>\n";
	        for (int i = 0; i < count; i++) {
	          result += "<th>" + rsmd.getColumnName(i + 1) + "</th>\n";
	        }
	        result += "<th>"+"Action"+"</th>\n";
	        result += "</tr>\n";
			while(rst.next()) {
				
//				book.setCategory(rst.getString("category"));
//				book.setTitle(rst.getString("title"));
//				book.setAuthor(rst.getString("author"));
//				book.setISBN( rst.getString("ISBN"));
//				book.setPublisher( rst.getString("publisher"));
//				book.setEditionNumber(rst.getString("editionNumber"));
//				book.setPrice( rst.getDouble("price"));
//				books.add(book);
				

		        // create data rows
		       
		          result += "<tr>\n";
		          for (int i = 0; i < count; i++) {
		            result += "<td>" + rst.getString(i + 1) + "</td>\n";
		           
		            
		          }
		          result += "<td> <button type=\"button\" class=\"btn btn-success\" id=<%=rst.getInt(\"idBook\") >" + "<i class=\"fas fa-edit\"></i> </button>" 
		                  + " <a href=\"../JSP/deleteAction.jsp?id=<%=resultSet.getInt(\"idBook\")%> \"> "+" <button type=\"button\" class=\"btn btn-danger\">\r\n" + "<i class=\"far fa-trash-alt\"></i></button></a>"
		        		  +"</td>\n";
		          result += "</tr>\n";
		        }
	        result += "</table>\n";
	        result += "</div>\n";
				
//				result += "<td>" + rst.getString("category") + "</td>\n";
//				result += "<td>" + rst.getString("title") + "</td>\n";
//				result += "<td>" + rst.getString("author") + "</td>\n";
//				result += "<td>" + rst.getString("ISBN") + "</td>\n";
//				result += "<td>" + rst.getString("publisher") + "</td>\n";
//				result += "<td>" + rst.getString("editionNumber") + "</td>\n";
//				result += "<td>" + rst.getDouble("price") + "</td>\n";
				
//				 for (int i = 0; i < count; i++) {
//			            result += "<td>" + rst.getString(i + 1) + "</td>\n";
//			          }
//				
//				
//				rst.getString("category");
//				rst.getString("title");
//				rst.getString("author");
//				rst.getString("ISBN");
//				rst.getString("publisher");
//				rst.getString("editionNumber");
//			    rst.getDouble("price");
			//    System.out.println(id +" "+book.toString());
				//				System.out.println("Category"+ " " +" Title" + " " + "Author" + " " + "ISBN" + " " +"Publiher" + " "
//						+ "Edition"+ " " + "Price");
//				System.out.println(category+ " " + title + " " + author + " " + ISBN + " " +publiher + " "
//				+ edition+ " " + price);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
	
		sql = "INSERT INTO book(category, title, author, ISBN, publisher, editionNumber, price) VALUES (?,?,?,?,?,?,?)";
		int insertRow= 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getCategory());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getISBN());
			psmt.setString(5, book.getPublisher());
			psmt.setString(6, book.getEditionNumber());
			psmt.setString(7, String.valueOf(book.getPrice()));
			insertRow=daoImp.insertData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertRow;
	
	}

	@Override
	public int delete(int id) {
		sql = "DELETE FROM book WHERE id = ? ";
		int deleteRow=0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			deleteRow=daoImp.deleteData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteRow;
		
		
	}

	@Override
	public void edit(int id, String category, String title, String author, String ISBN, String publisher, String editionNumber, String price ) {
		sql= "UPDATE book SET category = ?, title = ?, author = ?, ISBN = ?, publisher= ?, editionNumber = ?, price= ? WHERE id = '"+id+"'";
		int updateRow=0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
	
			
		    psmt.setInt(0, id);
//		    updateRow = daoImp.updateData(psmt);
			psmt.setString(1, category);
			psmt.setString(2, title);
			psmt.setString(3, author);
			psmt.setString(4, ISBN);
			psmt.setString(5, publisher);
			psmt.setString(6, editionNumber);
			psmt.setString(7, price);
			
			updateRow=daoImp.updateData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	//List single book
	public Book getOneBook(int id) {
		 Book row=null;
		try {
			sql = "select * from book where id=? ";
            PreparedStatement psmt = conn.prepareStatement(sql);
		    psmt.setInt(1, id);
		    ResultSet rst = daoImp.selectData(psmt);
		   
		    while(rst.next()) {
		    	row = new Book();
		    	row.setId(rst.getInt("id"));
		    	row.setCategory(rst.getString("category"));
		    	row.setTitle(rst.getString("title"));
		    	row.setAuthor(rst.getString("author"));
		    	row.setISBN( rst.getString("ISBN"));
		    	row.setPublisher( rst.getString("publisher"));
		    	row.setEditionNumber(rst.getString("editionNumber"));
		    	row.setPrice( rst.getDouble("price"));
		    	
		    }
		    
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            System.out.println(e.getMessage());
		}
		return row;
	}

	@Override
	public void purchaseHistory() {
		// TODO Auto-generated method stub
		
	}



}
