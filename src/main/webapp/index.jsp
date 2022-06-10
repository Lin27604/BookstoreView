<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.bookstore.helper.BookHelper"
	 import="java.sql.PreparedStatement" import= "java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
	      <link rel="stylesheet" href="View/bookstore.css">
          <script type="text/javascript" src="View/bookstore.js"></script>
          <meta charset="ISO-8859-1">
			<title>Online BookStore</title>
		</head>
<body class="background">
			<header class="header">
				<div class="btn1">
			<img
				src="View/book-tree-520x520.jpg"
				class="homeimg"/>

			<h1>
				<center>Online BookStore</center>
			</h1>
			
					<a href="index.jsp" ><button class="mybtn">Home</button></a>
					<a href="JSP/register.jsp" ><button class="mybtn">Register</button></a>
					<a href="JSP/login.jsp" ><button class="mybtn">Login</button></a>
				
				</div>
				
			</header>
			
			<hr>
	<div style="margin-right: 1000px">
		<form action="index.jsp" method ="get">
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
							<a href="JSP/register.jsp" class="btn btn-primary">ADD TO Cart</a>
							
							
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