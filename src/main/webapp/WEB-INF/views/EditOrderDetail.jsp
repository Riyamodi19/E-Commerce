<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New OrderDetail</title>
</head>
<body>
<h2>New OrderDetail</h2>
<form action="updateorderdetail" method="post">
Quantity: <input type="text" name="quantity" value="${orderDetail.quantity}"/><br><br>
Price: <input type="text" name="price" value="${orderDetail.price}"/><br><br>
OrderDetail Status : <select name="status" id="status" value="${orderdetail.status}" required>
                <option value="">-- Select Status --</option>
                <option value="Shipped">Shipped</option>
                <option value="Pending">Pending</option>
                <option value="Delivered">Delivered</option>
                <option value="Cancelled">Cancelled</option>
            </select><br><br>
<!--  Product Name:<select name="productId">
			<option>Select Product Name</option>
			
			<c:forEach items="${allProduct}" var="p">

					<option value="${p.productId}">${p.productName}</option>
			
			</c:forEach>

		</select> <br><br>-->
<input type="hidden" name="orderDetailId"  value="${orderDetail.orderDetailId}"/> 
		
		<input type="submit" value="Update OrderDeatil" />
</form>
</body>
</html>