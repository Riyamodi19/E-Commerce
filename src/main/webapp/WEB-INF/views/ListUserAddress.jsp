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
          </tr>
      <c:forEach items="${userAddressList}" var="m">
			<tr>
				<td>${m.title}</td>
				<td>${m.unitName}</td>
				<td>${m.street}</td>
				<td>${m.landMark}</td>
				<td>${m.zipCode}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>