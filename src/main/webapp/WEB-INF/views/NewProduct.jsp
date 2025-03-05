<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
<h2>New Product</h2>
<form action="saveproduct" method="post">
  Product Name: <input type="text" name="productName"><br><br>
  Category: <select name="categoryId">
			<option>Select Category</option>
			
			<c:forEach items="${allCategory}" var="c">

					<option value="${c.categoryId}">${c.categoryName}</option>
			
			</c:forEach>

		</select> <br><br>
  SubCategory Name :<select name="subCategoryId">
			<option>Select Sub Category</option>
			
			<c:forEach items="${allSubCategory}" var="s">

					<option value="${s.subCategoryId}">${s.subCategoryName}</option>
			
			</c:forEach>

		</select> <br><br>
  Product Detail: <input type="text" name="productDetail"><br><br>	
  Product ImageURL1: <input type="text" name="productImageURL1"><br><br>
  product ImageURL2: <input type="text" name="productImageURL2"><br><br>
  product ImageURL3: <input type="text" name="productImageURL3"><br><br>
  <input type="submit" value="save product">
</form>
</body>
</html>