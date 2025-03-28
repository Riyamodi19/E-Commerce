
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Product</title>
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
           color: blue;
        }
        .container {
            max-width: 1600px;
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
        <h2 class="text-center mb-4">View Product</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ProductName</th>
			          <th>CategoryName</th>
			          <th>SubCategoryName</th>
			          <th>BasePrice</th>
			          <th>OfferPrice</th>
			          <th>OfferPercentage</th>
			          <th>Product Detail</th>
			          <th>ProductImageURL1</th>
			          <th>productImageURL2</th>
			          <th>productImageURL3</th>
			          <th>Quantity</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${product}" var="p">
                    <tr>
                        <td>${p[10]}</td>
						<td>${p[13]}</td>
						<td>${p[14]}</td>
						<td>${p[1]}</td>
						<td>${p[5]}</td>
						<td>${p[4]}</td>
						<td>${p[6]}</td>
                        <td><img src="${p[7]}" height="100px" width="100px"></td>
                        <td><img src="${p[8]}" height="100px" width="100px"></td>
                        <td><img src="${p[9]}" height="100px" width="100px"></td>
						<td>${p[11]}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-center">
            <a href="listproduct" class="btn btn-primary btn-back">
                <i class="bi bi-arrow-left"></i> Back
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
