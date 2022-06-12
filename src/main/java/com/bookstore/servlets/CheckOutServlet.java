package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.entity.Cart;
import com.bookstore.entity.Order;
import com.bookstore.helper.OrderHelper;
import com.mysql.cj.Session;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/JSP/CheckOut")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        HttpSession session = request.getSession();
        StringBuffer path = new StringBuffer(request.getContextPath());
        String user=(String) session.getAttribute("logged");
        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
        OrderHelper oHelper =new OrderHelper();
        if (user != null) {
        	for(Cart c:cart_list) {
        		Order order = new Order();
				order.setUser(user);
				order.setBid(c.getId());
				order.setQunatity(c.getQuantity());
				order.setDate(formatter.format(date));
				boolean result = oHelper.insertOrder(order);
				if(!result) break;
        	}
        	cart_list.clear();
			response.sendRedirect(path+"/JSP/order.jsp");

        }else {
			if(user==null) {
				response.sendRedirect(path+"/JSP/login.jsp");
			}
			response.sendRedirect(path+"/JSP/cart.jsp");
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
