<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Reviews</title>
</head>
<body>
<h2>View Reviews</h2>
<table border="1">
         <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Product Name</th>
          <th>Review Text</th>
          <th>Rating</th>
          </tr>
      <c:forEach items="${reviews}" var="r">
			<tr>
			    <td>${r[6]}</td>
			    <td>${r[7]}</td>
			    <td>${r[8]}</td>
				<td>${r[3]}</td>
				<td>${r[4]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>