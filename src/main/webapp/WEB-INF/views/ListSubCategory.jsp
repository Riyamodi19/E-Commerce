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
          <th>SubCategory Name</th>
          <th>Action</th>
          </tr>
      <c:forEach items="${subcategoryList}" var="s">
			<tr>
				<td>${s.subCategoryName}</td>
				<td><a href="viewsubcategory?subCategoryId=${s.subCategoryId}">View</a> | <a href="deletesubcategory?subCategoryId=${s.subCategoryId}">Delete</a> | Edit </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>