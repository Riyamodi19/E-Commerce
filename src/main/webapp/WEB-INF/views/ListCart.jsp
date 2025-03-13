<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Cart</title>
</head>
<body>
<h2>List Cart</h2>
<table border="1">
         <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Product Name</th>
          <th>Cart Quantity</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${allCart}" var="c">
			<tr>
			    <td>${c[5]}</td>
			    <td>${c[6]}</td>
			    <td>${c[4]}</td>
				<td>${c[2]}</td>
				<td><a href="viewcart?cartId=${c[0]}">View</a> | <a href="deletecart?cartId=${c[0]}">Delete</a> | <a href="editcart?cartId=${c[0]}">Edit</a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>