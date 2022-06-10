package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.helper.CustomerHelper;

/**
 * Servlet implementation class message
 */
@WebServlet("/JSP/contact")
public class messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comment = request.getParameter("text");
	    HttpSession session = request.getSession();
	    String user=(String) session.getAttribute("logged");
	    String d = formatter.format(date);
	    CustomerHelper cHelper = new CustomerHelper();
	    if(user !=null || name !=null || email!= null || comment!=null) {
	    	
	    		cHelper.insertmessage(name, email, comment, d);
	    		out.println("<script type=\"text/javascript\">"); 
                out.println("alert('Message send successfully. We will response to you as soon as possible. "
                		+ "Please check you email. Thank you!');"); 
                out.println("location='home.jsp';"); 
                out.println("</script>"); 
	    }
	    else {
	    	response.sendRedirect("message.jsp");
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
