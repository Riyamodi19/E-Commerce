<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New UserAddress</title>
</head>
<body>
<h2>New UserAddress</h2>
<form action="saveuseraddress" method="post">
Title: <input type="text" name="title"><br><br>
Unit Name: <input type="text" name="unitName"><br><br>	
Street: <input type="text" name="street"><br><br>
LandMark: <input type="text" name="landMark"><br><br>	
ZipCode: <input type="text" name="zipCode"><br><br>
<input type="submit" value="save User Address">
</form>
</body>
</html>