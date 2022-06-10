<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.bookstore.helper.BookHelper"
	import="java.sql.PreparedStatement" import="java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<%
			  String i = request.getParameter("u");
              int id =Integer.parseInt(i);
			  String category = request.getParameter("category");
		      String title = request.getParameter("title");
		      String author = request.getParameter("author");
		      String isbn= request.getParameter("isbn");
		      String publisher = request.getParameter("publisher");
		      String edition = request.getParameter("edition");
		      String price=request.getParameter("price");
		     
		      if(category!=null &&title!=null && author!=null && isbn!=null && publisher!=null && edition!=null && price!=null){
		    	  
		    	  BookHelper helper = new BookHelper();
		    	  helper.edit(id, category, title, author, isbn, publisher, edition, price);
		    	  response.sendRedirect("../JSP/admin.jsp");
		    	  
		      }
		      else{
			%>
             <script>alert("Update Failed")</script>
             <%} %>
</body>
</html>