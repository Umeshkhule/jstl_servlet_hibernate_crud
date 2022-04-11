<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
	<h1>Add new product</h1>
	<form action="ProductServlet" method="post">
		<table>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="productName"
					placeholder="Enter name" /></td>
			</tr>
			<tr>
				<td>Product Price:</td>
				<td><input type="text" name="productPrice"
					placeholder="Enter price" /></td>
			</tr>
			<tr>
				<td>Product Quantity:</td>
				<td><input type="text" name="productQuantity"
					placeholder="Enter quantity" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="flag"
					value="AddProduct"> <input type="submit"
					value="Add Product"></td>
			</tr>
		</table>
	</form>
</body>
</html>