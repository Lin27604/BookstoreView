package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.Controller;
import com.bookstore.helper.RegisterHelper;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String appName = getServletContext().getInitParameter("appName");
		String pageName = getServletConfig().getInitParameter("pageName");
		
        response.setContentType("text/html");
		String username = request.getParameter("uname");
		String pswd = request.getParameter("psw");
		PrintWriter out = response.getWriter();
		RegisterHelper helper = new RegisterHelper();

		
		RequestDispatcher success = request.getRequestDispatcher("home");
		RequestDispatcher admin = request.getRequestDispatcher("admin.html");
		RequestDispatcher failure = request.getRequestDispatcher("login.html");
		
		
		if ((new Controller().login(username, pswd)) && (helper.isPwdValid(username).equals("admin")))
		{
			
			admin.forward(request, response);
		
		}else if (new Controller().login(username, pswd) ) {
			
	
			
			out.write("Login successfull");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//success.forward(request, response);
			response.sendRedirect("home");
			
		}
		else
		{
			
			failure.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
