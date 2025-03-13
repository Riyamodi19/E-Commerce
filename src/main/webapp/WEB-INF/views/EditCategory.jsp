<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Edit Category</title>
</head>
<body>
<h2>Edit Category</h2>
<form action="updatecategory" method="post">
Category Name: <input type="text" name="categoryName" value="${category.categoryName}"/><br><br>
		<input type="hidden" name="categoryId"  value="${category.categoryId}"/> 
		
		<input type="submit" value="Update Category" />
</form>
</body>
</html>