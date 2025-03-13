<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit SubCategory</title>
</head>
<body>
<h2>Edit SubCategory</h2>
	<form action="updatesubcategory" method="post">
	<!--  Category: <select name="categoryId">
			<option>Select Category</option>
			
			<c:forEach items="${allCategory}" var="c">

					<option value="${c.categoryId}">${c.categoryName}</option>
			
			</c:forEach>

		</select> <br><br>-->
SubCategory Name :<input type="text" name="subCategoryName"  value="${subcategory.subCategoryName}"><br><br>

<input type="hidden" name="subCategoryId"  value="${subcategory.subCategoryId}"/> 
		
		<input type="submit" value="Update SubCategory" />
	</form>
</body>
</html>