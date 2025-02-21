<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Reviews</title>
</head>
<body>
<h2>New Reviews</h2>
<form action="savereviews" method="post">	
	Review Text:<input type="text" name="reviewText"><br><br>		
	Rating: <input type="text" name="rating"><br><br>
	<input type="submit" value="submit">			
</form>
</body>
</html>