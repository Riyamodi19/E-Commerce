
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View User Address</title>
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">     
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .text-center{
            color:blue;
        }
        .container {
            max-width: 1000px;
        }
        .card {
            border-radius: 10px;
            background: #fff;
        }
        table {
            width: 100%;
        }
        th {
            background: #343a40;
            color: white;
            text-align: center;
        }
        td {
            background: #f1f1f1;
            text-align: center;
        }
        .btn-back {
            margin-top: 15px;
        }
    </style>
</head>
<body style="background: #D6DFE9;">

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h2 class="text-center mb-4">View User Address</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>FirstName</th>
			          <th>LastName</th>
			          <th>Title</th>
			          <th>UnitName</th>
			          <th>Street</th>
			          <th>LandMark</th>
			          <th>ZipCode</th>
			          <th>CityName</th>
			          <th>StateName</th>
			          <th>AddresDetail</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${useraddress}" var="u">
                    <tr>
                       <td>${u[13]}</td>
					    <td>${u[14]}</td>
						<td>${u[6]}</td>
						<td>${u[7]}</td>
						<td>${u[5]}</td>
						<td>${u[3]}</td>
						<td>${u[9]}</td>
						<td>${u[11]}</td>
						<td>${u[12]}</td>
						<td>${u[10]}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-center">
            <a href="listuseraddress" class="btn btn-primary btn-back">
                <i class="bi bi-arrow-left"></i> Back
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
