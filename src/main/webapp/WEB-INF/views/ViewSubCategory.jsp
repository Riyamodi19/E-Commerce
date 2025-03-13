<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view SubCategory</title>
</head>
<body>
<h2>View SubCategory</h2>
<table border="1">
         <tr>
         <th>Category Name</th>
          <th>SubCategory Name</th>
          </tr>
      <c:forEach items="${subcategory}" var="s">
			<tr>
			    <td>${s[3]}</td>
				<td>${s[2]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>