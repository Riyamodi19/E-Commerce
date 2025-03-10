<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Reviews</title>
</head>
<body>
<h2>List Reviews</h2>
<table border="1">
         <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Product Name</th>
          <th>Review Text</th>
          <th>Rating</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${allReviews}" var="r">
			<tr>
			    <td>${r[6]}</td>
			    <td>${r[7]}</td>
			    <td>${r[8]}</td>
				<td>${r[3]}</td>
				<td>${r[4]}</td>
				<td><a href="viewreviews?reviewId=${r[0]}">View</a> | <a href="deletereviews?reviewId=${r[0]}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>