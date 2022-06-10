<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bookstore.helper.BookHelper"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String no=request.getParameter("id");
int id = Integer.parseInt(no);

BookHelper helper = new BookHelper();
helper.delete(id);
response.sendRedirect("../JSP/admin.jsp");
%>

</body>
</html>