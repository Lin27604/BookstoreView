<%@page import="com.bookstore.entity.*"%>
<%@page import="com.bookstore.entity.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.text.DecimalFormat"
    import="java.util.*"
    import="com.bookstore.helper.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<% StringBuffer path = new StringBuffer(request.getContextPath()); %>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="<%= path %>/View/bookstore.css">
<script type="text/javascript" src="<%= path %>/View/bookstore.js"></script>
<link rel="stylesheet" href="<%= path %>/View/cart.css">
</head>
	<body>
		<header class="header">
			<div class="btn1" >
			<img
				src="<%= path %>/View/book-tree-520x520.jpg"
				class="homeimg"  />
				<h1>
					<center>Online BookStore</center>
				</h1>
				<a href="<%= path %>/JSP/home.jsp" ><button class="mybtn">Home</button></a>
			</div>
		</header>
		<hr>
		
             
	<%
      DecimalFormat dcf = new DecimalFormat("#.##");
        request.setAttribute("dcf", dcf);
        session.getAttribute("logged");
     ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
     List<Cart> cartProduct = null;
     if (cart_list != null) {
	CustomerHelper cHelper= new CustomerHelper();
	cartProduct = cHelper.getCartProducts(cart_list);
	double total = cHelper.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>			
	       
           
            
		<table class="list_table">
			<thead>
				<tr>
					<th scope="col">TITLE</th>
					<th scope="col">PRICE</th>
					<th scope="col">QUANTITY</th>
					<th scope="col">ACTION</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getTitle()%></td>
					<td><%= c.getPrice()%></td>
				
					<td>
						<form action="order" method="post" class="number">
						<input type="hidden" name="id" value="<%= c.getId()%>" >
						    <a href="quantity?action=inc&id=<%=c.getId()%>"><span class="minus">+</span></a>
								<input type="text" name="quantity" class="qu"  value="<%=c.getQuantity()%>" readonly> 	
						    <a href="quantity?action=dec&id=<%=c.getId()%>"><span class="plus">-</span></a>
						</form>
					</td>
					<td><a href="remove-item?id=<%=c.getId() %>" class="btn btn-danger">Remove</a></td>
				</tr>
				<%
				}}%>	
			</tbody>
		</table>
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3>
		<a href="<%= path %>/JSP/billing.jsp" ><button class="btn btn-primary btn-purchase" type="button">Check Out</a>
            <button type="button" onclick="cancelBooking()" id="cancelButton"class="btn btn-primary btn-purchase">Back</button>
	</div>
		
    </body>
</html>