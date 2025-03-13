<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Orders</title>
</head>
<body>
<h2>View Orders</h2>
<table border="1">
         <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Total Amount</th>
          <th>Status</th>
          </tr>
      <c:forEach items="${orders}" var="o">
			<tr>
			    <td>${o[5]}</td>
			    <td>${o[6]}</td>
				<td>${o[3]}</td>
				<td>${o[2]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>