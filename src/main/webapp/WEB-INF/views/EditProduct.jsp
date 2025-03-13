<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>
	<form action="updateproduct" method="post">
  Product Name: <input type="text" name="productName" value="${product.productName}"/><br><br>
  <!--  Category: <select name="categoryId">
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

		</select> <br><br>-->
  Base Price: <input type="text" name="basePrice" value="${product.basePrice}"/><br><br>		
  Offer Price: <input type="text" name="offerPrice" value="${product.offerPrice}"/><br><br>		
  Offer Percentage: <input type="text" name="offerPercentage" value="${product.offerPercentage}"/><br><br>		
  Product Detail: <input type="text" name="productDetail" value="${product.productDetail}"/><br><br>	
  Product ImageURL1: <input type="url" name="productImageURL1" value="${product.productImageURL1}"/><br><br>
  product ImageURL2: <input type="url" name="productImageURL2" value="${product.productImageURL2}"/><br><br>
  product ImageURL3: <input type="url" name="productImageURL3" value="${product.productImageURL3}"/><br><br>
  Quantity: <input type="number" name="quantity" value="${product.quantity}"/><br><br>
  
  <input type="hidden" name="productId"  value="${product.productId}"/> 
		
		<input type="submit" value="Update Product" />
</form>
</body>
</html>