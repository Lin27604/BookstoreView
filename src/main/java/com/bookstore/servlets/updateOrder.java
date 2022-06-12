package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.DAOImp;

/**
 * Servlet implementation class updateOrder
 */
@WebServlet("/JSP/updateOrder")
public class updateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("op");
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=UTF-8");
		 DAOImp daoImp = new DAOImp();
		Connection conn = daoImp.getConn();
		PrintWriter out = response.getWriter();
		System.out.println(id);
		System.out.println(operation);
		try {
			String sql= "UPDATE order_tb SET status= ? where id =? ";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, operation);
			psmt.setString(2, id);
			daoImp.updateData(psmt);
            response.sendRedirect("orderOperation.jsp");
		} catch (Exception e) {
			// TODO: handle exception
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
