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
          </tr>
      <c:forEach items="${productList}" var="m">
			<tr>
				<td>${m.productName}</td>
				<td>${m.productDetail}</td>
				<td>${m.productImageURL1}</td>
				<td>${m.productImageURL2}</td>
				<td>${m.productImageURL3}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>