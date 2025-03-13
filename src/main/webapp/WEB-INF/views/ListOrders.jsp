<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Orders</title>
</head>
<body>
<h2>List Orders</h2>
<table border="1">
         <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Total Amount</th>
          <th>Status</th>
           <th>Action</th>
          </tr>
      <c:forEach items="${allOrders}" var="o">
			<tr>
			    <td>${o[5]}</td>
			    <td>${o[6]}</td>
				<td>${o[3]}</td>
				<td>${o[2]}</td>
				<td><a href="vieworders?orderId=${o[0]}">View</a> | <a href="deleteorders?orderId=${o[0]}">Delete</a> | <a href="editorders?orderId=${o[0]}">Edit</a>  </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>