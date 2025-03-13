<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Product</title>
</head>
<body>
<h2>List Product</h2>
<table border="1">
         <tr>
          <th>Product Name</th>
          <th>Category Name</th>
          <th>SubCategory Name</th>
          <th>Base Price</th>
          <th>Offer Price</th>
          <th>Offer Percentage</th>
          <th>Product Detail</th>
          <th>Product ImageURL1</th>
          <th>product ImageURL2</th>
          <th>product ImageURL3</th>
          <th>Quantity</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${allProduct}" var="p">
			<tr>
				<td>${p[10]}</td>
				<td>${p[13]}</td>
				<td>${p[14]}</td>
				<td>${p[1]}</td>
				<td>${p[5]}</td>
				<td>${p[4]}</td>
				<td>${p[6]}</td>
				<td>${p[7]}</td>
				<td>${p[8]}</td>
				<td>${p[9]}</td>
				<td>${p[11]}</td>
				<td><a href="viewproduct?productId=${p[0]}">View</a> | <a href="deleteproduct?productId=${p[0]}">Delete</a> | <a href="editproduct?productId=${p[0]}">Edit</a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>