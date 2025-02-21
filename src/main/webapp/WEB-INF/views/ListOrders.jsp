<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Orders</title>
</head>
<body>
<h2>List Orders</h2>
<table border="1">
         <tr>
          <th>Total Amount</th>
          </tr>
      <c:forEach items="${ordersList}" var="m">
			<tr>
				<td>${m.totalAmount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>