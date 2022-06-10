package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.DAOImp;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  out.print("<div class=\"tbl-content\">");
		  out.print("<table class=\"list_table\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");
		  out.print("<tbody>");
		  try {
          String sql;
          DAOImp daoImp = new DAOImp();
      	  Connection conn = daoImp.getConn();
      	  String query =request.getParameter("q");
//      	  if(query!=null){
//      		sql = "SELECT * FROM book where category like '%"+query+"%' or title like '%"+query+"%' or author like '%"+query+"%'or ISBN like '%"+query+"%' or publisher like '%"+query+"%' or editionNumber like '%"+query+"%'or price like '%"+query+"%'";
//      	}else{
      		sql = "SELECT * FROM book";
//      	}
      	
      	PreparedStatement psmt = conn.prepareStatement(sql);
      	ResultSet rst = daoImp.selectData(psmt);
      	
			while (rst.next()){
				out.print("<tr>");	
				out.print("<td>" +rst.getString("category") +"</td>");
				out.print("<td>" +rst.getString("title") +"</td>");
				out.print("<td>" +rst.getString("author") +"</td>");
				out.print("<td>" +rst.getString("ISBN") +"</td>");
				out.print("<td>" +rst.getString("publisher") +"</td>");
				out.print("<td>" +rst.getString("editionNumber") +"</td>");
				out.print("<td>" +rst.getString("price") +"</td>");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  out.print("</tr>");
		  out.print("</tbody>");
		  out.print("</table>");
		  out.print("</div>");
		  
		  
		  out.print("");
		  out.print("");
   
   
   
 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
