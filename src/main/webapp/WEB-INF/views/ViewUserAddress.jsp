<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View User Address</title>
</head>
<body>
 <table border="1">
 <h2>View User Address</h2>
         <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Title</th>
          <th>Unit Name</th>
          <th>Street</th>
          <th>LandMark</th>
          <th>ZipCode</th>
          <th>City Name</th>
          <th>State Name</th>
          <th>Address Detail</th>
          </tr>
      <c:forEach items="${useraddress}" var="m">
			<tr>
			    <td>${m[13]}</td>
			    <td>${m[14]}</td>
				<td>${m[6]}</td>
				<td>${m[7]}</td>
				<td>${m[5]}</td>
				<td>${m[3]}</td>
				<td>${m[9]}</td>
				<td>${m[11]}</td>
				<td>${m[12]}</td>
				<td>${m[10]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</body>
</html>