<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  Base Price: <input type="text" name="basePrice"><br><br>
  Offer Price: <input type="text" name="offerPrice"><br><br>
  Offer Percentage: <input type="text" name="offerPercentage"><br><br>	
  Product Detail: <input type="text" name="productDetail"><br><br>	
  Product ImageURL1: <input type="text" name="productImageURL1"><br><br>
  product ImageURL2: <input type="text" name="productImageURL2"><br><br>
  product ImageURL3: <input type="text" name="productImageURL3"><br><br>
  <input type="submit" value="save product">
</form>
</body>
</html>