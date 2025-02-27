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
          <th>Product Detail</th>
          <th>Product ImageURL1</th>
          <th>product ImageURL2</th>
          <th>product ImageURL3</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${productList}" var="p">
			<tr>
				<td>${p.productName}</td>
				<td>${p.productDetail}</td>
				<td>${p.productImageURL1}</td>
				<td>${p.productImageURL2}</td>
				<td>${p.productImageURL3}</td>
				<td><a href="viewproduct?productId=${p.productId}">View</a> | <a href="deleteproduct?productId=${p.productId}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>