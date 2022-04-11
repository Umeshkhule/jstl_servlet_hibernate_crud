<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Product</h1>
	<table border="1" width="50%">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${productlist}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.productPrice}</td>
				<td>${product.productQuantity}</td>
				<td>
					<form action="ProductServlet?productId=${product.productId}"
						method="post">
						<input type="hidden" name="flag" value="UpdateProduct"> <input
							type="submit" value="Update Product">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</form>
					<form action="ProductServlet?productId=${product.productId}"
						method="post">
						<input type="hidden" name="flag" value="DeleteProduct"> <input
							type="submit" value="Delete Product">
					</form>
				</td>
			</tr>
		</c:forEach>
		<a href="index.jsp"> <input type="button" value="Home Page">
		</a>
		</form>
	</table>
</body>
</html>