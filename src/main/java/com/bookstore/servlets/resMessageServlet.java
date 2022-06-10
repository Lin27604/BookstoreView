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
 * Servlet implementation class resMessageServlet
 */
@WebServlet("/JSP/updateMess")
public class resMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=UTF-8");
		 DAOImp daoImp = new DAOImp();
			Connection conn = daoImp.getConn();
		PrintWriter out = response.getWriter();
		try {
			String sql= "UPDATE message SET Status= ? where idmesage ='"+id+"' ";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, operation);
			daoImp.updateData(psmt);
            response.sendRedirect("responseMessage.jsp");
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
