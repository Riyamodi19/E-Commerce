<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
  <h2>Change Password</h2>
  <form action="updatePassword" method="post">
   
     Email:<input type="text" name="email"><br><br>
     OTP: <input type="text" name="Otp"><br><br>
     New Password:<input type="password" name="password"><br><br>
     confirm password:<input type="password" name="confirmPassword"><br><br>
     
     <input type="submit" value="updatePassword">
  </form>
</body>
</html>