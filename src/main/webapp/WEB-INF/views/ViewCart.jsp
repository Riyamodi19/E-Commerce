<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cart</title>
</head>
<body>
<h2>View Cart</h2>
<table border="1">
         <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Product Name</th>
          <th>Cart Quantity</th>
         </tr>
      <c:forEach items="${cart}" var="c">
			<tr>
			    <td>${c[5]}</td>
			    <td>${c[6]}</td>
			    <td>${c[4]}</td>
				<td>${c[2]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>