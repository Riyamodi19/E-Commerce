<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Orders</title>
</head>
<body>
<h2>Edit Orders</h2>
	<form action="updateorders" method="post" >
Total Amount:<input type="text" name="totalAmount" value="${orders.totalAmount}"/><br><br>
		<input type="hidden" name="orderId"  value="${orders.orderId}"/> 
		
		<input type="submit" value="Update Order" />
</form>
</body>
</html>