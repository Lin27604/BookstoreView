<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bookstore.helper.BookHelper"
	 import="java.sql.PreparedStatement" import= "java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<% StringBuffer path = new StringBuffer(request.getContextPath());
%>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="<%= path %>/View/bookstore.css">
<script type="text/javascript" src="<%= path %>/View/bookstore.js"></script>


</head>
<body>
	<header class="header">
        <div class="btn1">
		<h1>
			<center>Online BookStore</center>
		</h1>
		<img src="<%= path %>/View/book-tree-520x520.jpg" class="homeimg"
			onclick="clickimage()" />
		
			
			
			
					
           <table style="margin-left: 1450px">
				<tr>
				
					<th>
			<%=(String) session.getAttribute("admin")%></th>
					<th><a href="<%= path %>/JSP/responseMessage.jsp"><button class="mybtn">Message</button></a></th>
					<th><a href="<%= path %>/JSP/orderOperation.jsp"><button class="mybtn">Order Operation</button></a></th>
					
								<form action="<%= path %>/logout">
						<th><input type="submit" value="logout" class="mybtn">
						</th>
					</form>
				</tr>
			</table>
		</div>


	</header>

	<hr>
	<div class="col1">
		<div class="col2">
			<h4>Add New Book</h4>
			<form action="<%= path %>/JSP/insertAction.jsp">
				<div>
					<label>Category:</label> <input type="text"
						placeholder="Enter the Category" name="category" class="insert">
				</div>
				<div>
					<label>Title:</label> <input type="text"
						placeholder="Enter the Book Title" name="title" class="insert">
				</div>
				<div>
					<label>Author:</label> <input type="text"
						placeholder="Enter the Book Author" name="author" class="insert">
				</div>
				<div>
					<label>ISBN:</label> <input type="text"
						placeholder="Enter the Book ISBN" name="isbn" class="insert">
				</div>
				<div>
					<label>Publisher:</label> <input type="text"
						placeholder="Enter the Publisher" name="publisher" class="insert">
				</div>
				<div>
					<label>Edition:</label> <input type="text"
						placeholder="Enter the Book Edition" name="edition" class="insert">
				</div>
				<div>
					<label>Price:</label> <input type="text"
						placeholder="Enter the Book Price" pattern="^[0-9]*$" name="price" class="insert">
				</div>

				<button type="submit" class="btn btn-default">Submit</button>


			</form>
			</div>
			
		</div>
		<div class="col1">
		     <form action="<%= path %>/JSP/admin.jsp" method ="get">
					<input type="text" placeholder="Search Here..." name="q" class="insert"/>
		     </form>
		</div>
		<div  class="tbl-content">
<!--
			  <%BookHelper bHelper= new BookHelper(); %>
                            <%=bHelper.display() %>
                            -->

			<table class="books">
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
				</thead>
					<tbody>
				<%   
                
				           
                            String sql;
                            DAOImp daoImp = new DAOImp();
                        	Connection conn = daoImp.getConn();
                        	String query =request.getParameter("q");
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
						<td>
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
						<td>
							<%=rst.getString("price")%>
						</td>

						<td><form action="<%= path %>/JSP/updateForm.jsp">
						<input type="hidden" value="<%=rst.getString("id")%>" name="u"/>
						<input type="submit" value="Update" class="btn1 mybtn"/>
						</form>
	
							<a href="<%= path %>/JSP/deleteAction.jsp?id=<%=rst.getString("id")%>" class="btn1 mybtn">Delete</a>
						</td>
					</tr>
					
				
				
				<%
                }
			
                 %>
                 </tbody>

			</table>
	

		
		


	</div>

</body>
</html>