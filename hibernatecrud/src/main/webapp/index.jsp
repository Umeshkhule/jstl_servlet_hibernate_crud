<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="ProductServlet" method="post">
		<a href="addProduct.jsp"><input type="button" value="Add product"></a>
		<input type="hidden" name="flag" value="ViewProduct"> <input
			type="submit" value="View Product">
	</form>
</body>
</html>