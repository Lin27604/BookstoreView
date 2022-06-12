package com.bookstore.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.bookstore.entity.*;
import com.bookstore.model.DAOImp;

public class OrderHelper {
	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();
	public boolean insertOrder(Order order) {
        boolean result = false;
        try {
           String sql = "insert into order_tb (buyer, book, quantity, date) values(?,?,?,?)";
           PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, order.getUser());
            psmt.setInt(2, order.getBid());
            psmt.setInt(3, order.getQunatity());
            psmt.setString(4, order.getDate());
            daoImp.updateData(psmt);
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	public List<Order> orderList(String user){
		List<Order> list = new ArrayList<>();
		try {
	           String sql = "select * from order_tb where buyer=?";
	           PreparedStatement psmt = conn.prepareStatement(sql);
	           psmt.setString(1, user);
	           ResultSet rst = daoImp.selectData(psmt);
	           while(rst.next()) {
	        	   Order order = new Order();
	        	   BookHelper bookHelper = new BookHelper();
	        	   int bId= rst.getInt("book");
	        	   Book book=bookHelper.getOneBook(bId);
	        	   order.setUser(user);
	        	   order.setTitle(book.getTitle());
	        	   order.setPrice(String.valueOf(Double.parseDouble( book.getPrice())*rst.getInt("quantity")));
	        	   order.setQunatity(rst.getInt("quantity"));
	        	   order.setDate(rst.getString("date"));
	        	   order.setStatus(rst.getString("status"));
	        	   list.add(order);
	        	   
	           }
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		return list;

}
	public List<Order> AllorderList(){
		List<Order> list = new ArrayList<>();
		try {
	           String sql = "select * from order_tb WHERE NOT (Status <=> 'Completed')";
	           PreparedStatement psmt = conn.prepareStatement(sql);
	           
	           ResultSet rst = daoImp.selectData(psmt);
	           while(rst.next()) {
	        	   Order order = new Order();
	        	   BookHelper bookHelper = new BookHelper();
	        	   int bId= rst.getInt("book");
	        	   Book book=bookHelper.getOneBook(bId);
	        	   order.setId(rst.getInt("id"));
	        	   order.setUser(rst.getString("buyer"));
	        	   order.setTitle(book.getTitle());
	        	   order.setPrice(String.valueOf(Double.parseDouble( book.getPrice())*rst.getInt("quantity")));
	        	   order.setQunatity(rst.getInt("quantity"));
	        	   order.setDate(rst.getString("date"));
	        	   order.setStatus(rst.getString("status"));
	        	   list.add(order);
	        	   
	           }
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		return list;

}
	
	
	
}