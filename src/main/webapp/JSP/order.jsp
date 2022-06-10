<%@page import="com.bookstore.entity.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.text.DecimalFormat"
    import="java.util.*"
    import="com.bookstore.helper.*"
    import="com.bookstore.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="../View/bookstore.css">
<script type="text/javascript" src="../View/bookstore.js"></script>

</head>
	<header class="header">
		<div class="btn1">

			<img src="../View/book-tree-520x520.jpg" class="homeimg" />
			<h1>
				<center>Online BookStore</center>
				
			</h1>

			<table style="margin-left: 1450px">
				<tr>
				
					<th><a href="home.jsp"><button class="mybtn">Home</button></a></th>
					<th><a href="order.jsp"><button class="mybtn">Order</button></a></th>
					<th><a href="message.jsp"><button class="mybtn">Message</button></a></th>
					
					<th><a href="cart.jsp" class="mybtn">Go
								to Cart<span class="badge badge-danger">${cart_list.size()}</span></a></th>
								<form action="logout">
						<th><input type="submit" value="logout" class="mybtn">
						</th>
					</form>
				</tr>
			</table>
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
		orders= oHelper.orderList(user);
		
	}
	else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}	
%>

<div class="container">
		<div class="row">All Orders</div>
		<table class="books">
			<thead>
				<tr>
					
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
						
						<td><%=o.getTitle()%></td>
						<td><%=o.getQunatity() %></td>
						<td><%=dcf.format(o.getPrice())%></td>
						<td><%=o.getDate()%></td>
						<td><%=o.getStatus()%></td>
						
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>


</body>
</html>