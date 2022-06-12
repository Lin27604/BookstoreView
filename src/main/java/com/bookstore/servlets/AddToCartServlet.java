package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.entity.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		StringBuffer path = new StringBuffer(request.getContextPath());
		try {
			
			 ArrayList<Cart> cartList = new ArrayList<>();
	         int id = Integer.parseInt(request.getParameter("id"));
	         Cart cart= new Cart();
	         cart.setId(id);
	         cart.setQuantity(1);
	         HttpSession session =request.getSession();
	         
	         ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	         if(cart_list==null) {
	        	 cartList.add(cart);
	        	 session.setAttribute("cart-list", cartList);
	             out.println("<script type=\"text/javascript\">"); 
                 out.println("alert('Item added to cart...');"); 
                 out.println("</script>");
	        	// out.println("Session add...");
                 response.sendRedirect(path+"/JSP/home.jsp");
          
	        	 
	         }else {
	                cartList = cart_list;

	                boolean exist = false;
	                for (Cart c : cart_list) {
	                	out.println(c.getId());
	                    if (c.getId() == id) {
	                        exist = true;
	                        out.println("<script type=\"text/javascript\">"); 
	                        out.println("alert('Item already in the cart...');"); 
	                        out.println("location='/JSP/home.jsp';"); 
	                        out.println("</script>"); 
	                    }
	                }

	                if (!exist) {
	                    cartList.add(cart);
	                    response.sendRedirect(path+"/JSP/home.jsp");
	                }
	         }
		}catch (Exception e) {
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
