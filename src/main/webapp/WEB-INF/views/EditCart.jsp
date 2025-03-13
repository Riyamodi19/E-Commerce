<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Cart</title>
</head>
<body>
<h2>Edit Cart</h2>
	<form action="updatecart" method="post">
Quantity: <input type="text" name="quantity" value="${cart.quantity}"><br><br>
 <!--  Product:<select name="productId">
			<option>Select Product</option>
			
			<c:forEach items="${allProduct}" var="p">

					<option value="${p.productId}">${p.productName}</option>
			
			</c:forEach>

		</select> <br><br>-->
<input type="hidden" name="cartId"  value="${cart.cartId}"/> 
		
		<input type="submit" value="Update Cart" /></form>
</body>
</html>