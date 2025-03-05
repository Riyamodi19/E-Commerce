<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New SubCategory</title>
</head>
<body>
<h2>New SubCategory</h2>
<form action="savesubcategory" method="post">
Category: <select name="categoryId">
			<option>Select Category</option>
			
			<c:forEach items="${allCategory}" var="c">

					<option value="${c.categoryId}">${c.categoryName}</option>
			
			</c:forEach>

		</select> <br><br>
SubCategory Name :<input type="text" name="subCategoryName"><br><br>
<input type="submit" value="save subcategory">
</form>
</body>
</html>