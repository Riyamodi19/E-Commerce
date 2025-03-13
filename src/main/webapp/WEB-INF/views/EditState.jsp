<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit State</title>
</head>
<body>
<h2>Edit State</h2>
	<form action="updatestate" method="post">
   <!-- States of India -->
State Name:<input type="text" name="stateName" value="${state.stateName}"/><br><br>
		<input type="hidden" name="stateId"  value="${state.stateId}"/> 
		
		<input type="submit" value="Update State" />

 </form>
</body>
</html>