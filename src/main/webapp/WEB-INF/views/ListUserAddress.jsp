<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User Address</title>
</head>
<body>
<h2>List User Address</h2>
<table border="1">
         <tr>
          <th>Title</th>
          <th>UnitName</th>
          <th>Street</th>
          <th>LandMark</th>
          <th>ZipCode</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${userAddressList}" var="u">
			<tr>
				<td>${u.title}</td>
				<td>${u.unitName}</td>
				<td>${u.street}</td>
				<td>${u.landMark}</td>
				<td>${u.zipCode}</td>
				<td><a href="viewuseraddress?userAddressId=${u.userAddressId}">View</a> | <a href="deleteuseraddress?userAddressId=${u.userAddressId}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>