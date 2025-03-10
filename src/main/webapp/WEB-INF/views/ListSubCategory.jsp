<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List SubCategory</title>
</head>
<body>
<h2>List SubCategory</h2>
<table border="1">
         <tr>
         <th>Category Name</th>
          <th>SubCategory Name</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${allsubCategory}" var="s">
			<tr>
			    <td>${s[3]}</td>
				<td>${s[2]}</td>
				<td><a href="viewsubcategory?subCategoryId=${s[0]}">View</a> | <a href="deletesubcategory?subCategoryId=${s[0]}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>