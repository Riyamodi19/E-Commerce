<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
AddressDetail:<input type="text" name="addressDetail"><br><br>
ZipCode: <input type="text" name="zipCode"><br><br>
City: <select name="cityId">
			<option>Select City</option>
			
			<c:forEach items="${allCity}" var="c">

					<option value="${c.cityId}">${c.cityName }</option>
			
			</c:forEach>

		</select> <br><br>
State: <select name="stateId">
			<option>Select State</option>
			
			<c:forEach items="${allState}" var="s">

					<option value="${s.stateId}">${s.stateName }</option>
			
			</c:forEach>

		</select> <br><br>
<input type="submit" value="save User Address">
</form>
</body>
</html>