<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
        import="com.bookstore.helper.BookHelper"
	import="java.sql.PreparedStatement" import="java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="../View/bookstore.css">
<script type="text/javascript" src="../View/bookstore.js"></script>
</head>
<body>
			<form action="Update" class="wrapper">
			
			<%
			                String i = request.getParameter("u");
			                int num= Integer.parseInt(i);
							String sql = "SELECT * FROM book WHERE id='"+num+"'";
							DAOImp daoImp = new DAOImp();
							Connection conn = daoImp.getConn();
							PreparedStatement psmt = conn.prepareStatement(sql);
							ResultSet rst = daoImp.selectData(psmt);
							while (rst.next()) {
							%>
				<input type="hidden" name="id" value="<%=rst.getString("id") %>">
						
				<div>
					<label>Category:</label> <input type="text"
						placeholder="Enter the Category" name="category" class="insert" value="<%=rst.getString("category")%>"/>
				</div>
				<div>
					<label>Title:</label> <input type="text"
						placeholder="Enter the Book Title" name="title" class="insert" value="<%=rst.getString("title")%>"/>
				</div>
				<div>
					<label>Author:</label> <input type="text"
						placeholder="Enter the Book Author" name="author" class="insert" value="<%=rst.getString("author")%>"/>
				</div>
				<div>
					<label>ISBN:</label> <input type="text"
						placeholder="Enter the Book ISBN" name="isbn" class="insert" value="<%=rst.getString("ISBN")%>"/>
				</div>
				<div>
					<label>Publisher:</label> <input type="text"
						placeholder="Enter the Publisher" name="publisher" class="insert" value="<%=rst.getString("publisher")%>"/>
				</div>
				<div>
					<label>Edition:</label> <input type="text"
						placeholder="Enter the Book Edition" name="edition" class="insert" value="<%=rst.getString("editionNumber")%>"/>
				</div>
				<div>
					<label>Price:</label> <input type="number"
						placeholder="Enter the Book Price" name="price" class="insert" value="<%=rst.getString("price")%>"/>
				</div>
				<% 
				} 
				%>

				<button type="submit" class="btn btn-warning">Update</button>
				<a href="../JSP/admin.jsp" class="btn btn-default">Back</a>
			</form>

</body>
</html>
			

