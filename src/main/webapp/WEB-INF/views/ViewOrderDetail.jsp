<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order Detail</title>
</head>
<body>
<h2>View Order Detail</h2>
<table border="1">
         <tr>
         <th>Product Name</th>
          <th>Quantity</th>
          <th>Price</th>
          <th>Status</th>
          </tr>
      <c:forEach items="${orderDetail}" var="o">
			<tr>
			    <td>${o[6]}</td>
				<td>${o[4]}</td>
				<td>${o[2]}</td>
				<td>${o[5]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>