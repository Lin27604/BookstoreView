<%@page import="com.bookstore.controller.BookController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new book</title>
</head>
<body>
   <% 
    StringBuffer path = new StringBuffer(request.getContextPath());
      String category = request.getParameter("category");
      String title = request.getParameter("title");
      String author = request.getParameter("author");
      String isbn= request.getParameter("isbn");
      String publisher = request.getParameter("publisher");
      String edition = request.getParameter("edition");
      String price =request.getParameter("price");
      
      BookController bookController= new BookController();
      if(bookController.insertBook(category, title, author, isbn, publisher, edition, price)){
    	  response.sendRedirect(path+"/JSP/admin.jsp");
    	 
   }
      
      else
      %>
       <script>alert("Insertion Failed")</script>  

</body>
</html>