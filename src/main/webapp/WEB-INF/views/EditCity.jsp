<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit City</title>
</head>
<body>
<h2>Edit City</h2>
	<form action="updatecity" method="post">
		City name: <input type="text" name="cityName" value="${city.cityName}" /><br> <br>
	<!--  	<br> State: <select name="stateId">
			<option>Select State</option>
			
			<c:forEach items="${allState}" var="s">

					<option value="${s.stateId}">${s.stateName}</option>
			
			</c:forEach>

		</select> <br><br> -->
		<input type="hidden" name="cityId"  value="${city.cityId}"/> 
		
		<input type="submit" value="Update City" />
	</form>

</body>
</html>