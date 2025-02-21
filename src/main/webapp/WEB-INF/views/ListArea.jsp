<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Area</title>
</head>
<body>
<h2>List Area</h2>
<table border="1">
         <tr>
          <th>Area Name</th>
          </tr>
      <c:forEach items="${areaList}" var="m">
			<tr>
				<td>${m.areaName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>