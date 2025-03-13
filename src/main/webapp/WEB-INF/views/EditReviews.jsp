<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Reviews</title>
</head>
<body>
<h2>Edit Reviews</h2>
	<form action="updatereviews" method="post">
	
	Review Text:<input type="text" name="reviewText" value="${reviews.reviewText}"/><br><br>		
	Rating: <input type="text" name="rating" value="${reviews.rating}"/><br><br>
	<!--  Product:<select name="productId">
			<option>Select Product</option>
			
			<c:forEach items="${allProduct}" var="p">

					<option value="${p.productId}">${p.productName}</option>
			
			</c:forEach>

		</select> <br><br>-->
			<input type="hidden" name="reviewId"  value="${reviews.reviewId}"/> 
		
		<input type="submit" value="Update Review" />
		
</form>
</body>
</html>