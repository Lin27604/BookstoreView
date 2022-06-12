<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.bookstore.helper.BookHelper"
	 import="java.sql.PreparedStatement" import= "java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"
	import="java.util.*"%>
	<%@page import="com.bookstore.entity.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	

	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<% StringBuffer path = new StringBuffer(request.getContextPath());
%>
<%= path %>
<link rel="stylesheet" href="<%= path %>/View/bookstore.css">
<script type="text/javascript" src="<%= path %>/View/bookstore.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="header">
		<div class="btn1">

			<img src="<%= path %>/View/book-tree-520x520.jpg" class="homeimg" />
			<h1>
				<center>Online BookStore</center>
				
			</h1>

			<table style="margin-left: 1450px">
				<tr>
				
					<th><a href="<%= path %>/JSP/home.jsp"><button class="mybtn">Home</button></a></th>
					<th><a href="<%= path %>/JSP/order.jsp"><button class="mybtn">Order</button></a></th>
					<th><a href="<%= path %>/JSP/message.jsp"><button class="mybtn">Message</button></a></th>
					
					<th><a href="<%= path %>/JSP/cart.jsp" class="mybtn">Go
								to Cart<span class="badge badge-danger">${cart_list.size()}</span></a></th>
								<form action="<%= path %>/logout">
						<th><input type="submit" value="logout" class="mybtn">
						</th>
					</form>
				</tr>
			</table>
		</div>
		
	</header>

	<hr>
	
<div style="margin-right: 1000px">
		<form action="<%= path %>/JSP/home.jsp" method ="get">
					<input type="text" placeholder="Search Here..." name="q" class="input"/>
		     </form>
		     </div>
<div>
	<form action="data" method="post">
		<div class="tbl-header">
			<table class="books" cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Category</th>
						<th>Title</th>
						<th>Author</th>
						<th>ISBN</th>
						<th>Publisher</th>
						<th>Edition</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
				<thead>
		
		
			
					<tbody>
		                <%   
		                    session.getAttribute("logged");
                            String sql;
                            DAOImp daoImp = new DAOImp();
                        	Connection conn = daoImp.getConn();
                        	String query =request.getParameter("q");
                        	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
                        	if (cart_list != null) {
                        		request.setAttribute("cart_list", cart_list);
                        	}
                        	if(query!=null){
                        		sql = "SELECT * FROM book where category like '%"+query+"%' or title like '%"+query+"%' or author like '%"+query+"%'or ISBN like '%"+query+"%' or publisher like '%"+query+"%' or editionNumber like '%"+query+"%'or price like '%"+query+"%'";
                        	}else{
                        		sql = "SELECT * FROM book";
                        	}
                        	
                        	PreparedStatement psmt = conn.prepareStatement(sql);
                        	ResultSet rst = daoImp.selectData(psmt);
                        	while (rst.next()){
                       %>
			
					<tr>
						<td>
							<%=rst.getString("category")%>
						</td>
						<td class="shop-item-title">
							<%=rst.getString("title")%>
						</td>
						<td>
							<%= rst.getString("author")%>
						</td>
						<td>
							<%= rst.getString("ISBN")%>
						</td>
						<td>
							<%=rst.getString("publisher") %>
						</td>
						<td>
							<%=rst.getString("editionNumber") %>
						</td>
						<td class="shop-item-price">
							<%=rst.getString("price")%>
						</td>

						<td>
							<a href="<%= path %>/add-to-cart?id=<%=rst.getString("id")%>" class="btn btn-primary">ADD TO Cart</a>
							
							
						</td>
					</tr>
					
				
				
				<%
                }
			
                 %>
					</tbody>
				</table>
		
		</div>
	</form>
	</div>



</body>
</html>