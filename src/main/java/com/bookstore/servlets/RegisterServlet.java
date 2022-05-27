package com.bookstore.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.Controller;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String appName = getServletContext().getInitParameter("appName");
		String pageName = getServletConfig().getInitParameter("pageName");
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String username = request.getParameter("uname");
		String pswd = request.getParameter("psw");
		String pswRepeat = request.getParameter("psw-repeat");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		RequestDispatcher success = request.getRequestDispatcher("home");
		RequestDispatcher failure = request.getRequestDispatcher("register.html");
				
				
		if(new Controller().register(name, age, username, pswd, pswRepeat, email, phone, address)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("home");
			
		}
		else {
			failure.include(request, response);
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
