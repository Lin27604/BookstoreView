<%@page import="java.sql.SQLException"%>
<%@page import="com.bookstore.entity.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.bookstore.helper.BookHelper"
	 import="java.sql.PreparedStatement" import= "java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"
	import ="com.bookstore.entity.Book"
	 import="java.text.DecimalFormat"
    import="java.util.*"
    import="com.bookstore.helper.*"
    import="com.bookstore.entity.*"%>
<!DOCTYPE html>
<html>
<% StringBuffer path = new StringBuffer(request.getContextPath()); %>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="<%= path %>/View/bookstore.css">
<script type="text/javascript" src="<%= path %>/View/bookstore.js"></script>

</head>
	<header class="header">
		<div class="btn1">

			<img src="<%= path %>/View/book-tree-520x520.jpg" class="homeimg" />
			<h1>
				<center>Online BookStore</center>
				
			</h1>

			
					<a href="admin.jsp"><button class="mybtn">Home</button></a>
						
			
		</div>
		
	</header>

	<hr>
<body>
<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	String user =(String) request.getSession().getAttribute("logged");
	
	List<Order> orders = null;
	if(user !=null){
	
		OrderHelper oHelper = new OrderHelper();
		orders= oHelper.AllorderList();
		
	}
	else{
		response.sendRedirect("login.jsp");
	}	
%>

<div class="container">
		<div class="row">All Orders</div>
		<table class="books">
			<thead>
				<tr>
					<th scope="col">Buyer</th>
					<th scope="col">Title</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Date</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			  <tbody>
  <%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getUser()%></td>
						<td><%=o.getTitle()%></td>
						<td><%=o.getQunatity() %></td>
						<td><%=o.getPrice()%></td>
						<td><%=o.getDate()%></td>
						 <td><form action="updateOrder"><select name="op">
      
      <option >Processing</option>
      <option >Completed</option>
      
      </select>
      <input type="hidden" value="<%=o.getId()%>" name="id"/>
      <input type="submit" class="btn btn-success" value="Upadte"/></td>
			</form>			
					</tr>
				<%}
			}
			%>
    <tr>

  </tbody>
		</table>
	</div>


</body>
</html>