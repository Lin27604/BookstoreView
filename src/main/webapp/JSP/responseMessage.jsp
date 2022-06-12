<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.bookstore.helper.BookHelper"
	 import="java.sql.PreparedStatement" import= "java.sql.ResultSet"
	import="com.bookstore.model.DAOImp" import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="../View/message.css">
<link rel="stylesheet" href="../View/bookstore.css">
<script type="text/javascript" src="../View/bookstore.js"></script>
</head>
<body class="resbody">
	<header class="header">
        <div class="btn1">
		<h1>
			<center>Online BookStore</center>
		</h1>
		
		
			<label for="welcome">Welcome:</label>
			<%=(String) session.getAttribute("admin")%>
			<a href="admin.jsp"><button class="mybtn">Home</button></a>
			<a href=""><button class="mybtn">Orders</button></a>
           
		</div>


	</header>
	

<table class= "restable">
  <caption>Message</caption>
  <thead>
  
    <tr>
      <th scope="col">Name</th>
      <th scope="col">email</th>
      <th scope="col">comment</th>
      <th scope="col">date</th>
      <th scope="col">Action</th>
    
    </tr>
  </thead>
  <tbody>
  <%
	String sql = "select * from message WHERE NOT (Status <=> 'Responded')";
	PreparedStatement psmt;
	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();
	try {
		psmt = conn.prepareStatement(sql);
		ResultSet rst = daoImp.selectData(psmt);
		while (rst.next()) {
	%>
    <tr>
      <td ><%=rst.getString("name")%></td>
      <td ><%=rst.getString("email")%></td>
      <td ><%=rst.getString("comment")%></td>
      <td ><%=rst.getString("date")%></td>
      
      <td><form action="updateMess"><select name="operation">
      
      <option >Waiting</option>
      <option >Responded</option>
      
      </select>
      <input type="hidden" value="<%=rst.getInt("idmesage")%>" name="id"/>
      <input type="submit" class="btn mybtn" value="Upadte"/></td>
      </form>
    </tr>
 <%}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}%>
   
  </tbody>
</table>

</body>
</html>