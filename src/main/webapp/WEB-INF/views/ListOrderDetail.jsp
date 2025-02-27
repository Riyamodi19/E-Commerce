<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Order Detail</title>
</head>
<body>
<h2>List Order Detail</h2>
<table border="1">
         <tr>
          <th>Quantity</th>
          <th>Price</th>
           <th>Action</th>
          </tr>
      <c:forEach items="${orderDetailList}" var="o">
			<tr>
				<td>${o.quantity}</td>
				<td>${o.price}</td>
				<td><a href="vieworderdetail?orderDetailId=${o.orderDetailId}">View</a> | <a href="deleteorderdetail?orderDetailId=${o.orderDetailId}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>