<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<% StringBuffer path = new StringBuffer(request.getContextPath());
%>
<head>
<link rel="stylesheet" href="<%= path %>/View/bookstore.css">
<script type="text/javascript" src="<%= path %>/View/bookstore.js"></script>
<meta charset="ISO-8859-1">
<title>Online BookStore</title>
</head>

<body>
	<header class="header">
		<div class="btn1">
			<img
				src="<%= path %>/View/book-tree-520x520.jpg"
				class="homeimg" onclick="clickimage()" />

			<h1>
				<center>Online BookStore</center>
			</h1>
			<a href="<%= path %>/index.jsp"><button class="mybtn">Home</button></a> 
			<a href="<%= path %>/JSP/register.jsp"> <button class="mybtn">Register</button></a>
		</div>

	</header>
	<hr>


	<form action="<%=path %>/login" class="wrapper"  method="post">
		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="uname" class="input" required />

			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" class="input" id="pswd"
				required> <span id="strength"></span> <input type="checkbox"
				onclick="showPsd()" />Show Password<br>
			<br>

			<input type="submit" class="mybtn" value="Login">
			<input type="button" value="Cancel" onclick="cancelBooking()"
				class="mybtn">
		</div>
	</form>
</body>
</html>