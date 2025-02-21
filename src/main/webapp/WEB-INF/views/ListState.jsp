<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State</title>
</head>
<body>
<h2>State</h2>
<table border="1">
         <tr>
          <th>State Name</th>
          </tr>
      <c:forEach items="${stateList}" var="m">
			<tr>
				<td>${m.stateName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>