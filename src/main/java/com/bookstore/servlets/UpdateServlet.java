package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.helper.BookHelper;
import com.bookstore.model.DAOImp;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/JSP/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		  DAOImp daoImp = new DAOImp();
			Connection conn = daoImp.getConn();
		  String id = request.getParameter("u");
		  String category = request.getParameter("category");
	      String title = request.getParameter("title");
	      String author = request.getParameter("author");
	      String isbn= request.getParameter("isbn");
	      String publisher = request.getParameter("publisher");
	      String edition = request.getParameter("edition");
	      String price=request.getParameter("price");
	      
	      System.out.println(price);
	      
	     
	      if(category!=null &&title!=null && author!=null && isbn!=null && publisher!=null && edition!=null && price!=null){
	    	  
	  		String sql= "UPDATE book SET category = ?, title = ?, author = ?, ISBN = ?, publisher= ?, editionNumber = ?, price= ? WHERE id = '"+id+"'";
		
	  		try {
				
	
				PreparedStatement psmt = conn.prepareStatement(sql);				
			   // psmt.setInt(1, id);
//			    updateRow = daoImp.updateData(psmt);
				
				psmt.setString(1, category);
				psmt.setString(2, title);
				psmt.setString(3, author);
				psmt.setString(4, isbn);
				psmt.setString(5, publisher);
				psmt.setString(6, edition);
				psmt.setString(7, price);
                daoImp.updateData(psmt);
                response.sendRedirect("../JSP/admin.jsp");
	  		}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	      }
	
	      }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
