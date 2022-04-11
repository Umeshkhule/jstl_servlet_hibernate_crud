<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit QProduct</h1>


<c:forEach items="${sessionScope.productlist}" var="product">	
<form action="ProductServlet?productId=${product.productId}" method="post">
	<table >
		<tr>
			<td>Product Name:</td>
			<td><input type="text" value="${product.productName}" name="productName"></td>
		</tr>
		<tr>
			<td>Product Price:</td>
			<td><input type="text" value="${product.productPrice}" name="productPrice"></td>
		</tr>
		<tr>
			<td>Product Quantity:</td>
			<td><input type="text" value="${product.productQuantity}" name="productQuantity"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="hidden" name="flag" value="UpdateToDB">
			<input type="submit" value="Update Product"></td>			
		</tr>
	</table>
</form>
</c:forEach>



</body>
</html>