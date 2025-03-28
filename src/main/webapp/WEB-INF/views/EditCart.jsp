<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --> 

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Cart</title>
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
        .container {
            max-width: 600px;
        }
        .card {
            border-radius: 10px;
            background: #fff;
            padding: 20px;
        }
        .form-label {
            font-weight: bold;
            font-size:21px;
        }
        .btn-submit {
            width: 30%;
            padding: 9px;
            background: #007bff;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            transition: background 0.3s ease;
        }
        .btn-submit:hover {
            background: #0056b3;
            color:#e6e6fa;
        }
        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            color: #667eea;
            text-decoration: none;
            font-weight: 600;
            font-size: 18px;
        }

        .back-link a:hover {
            text-decoration: underline;
            color:#8b008b;
        }
    </style>
</head>
<body style="background: #D6DFE9;">

<div class="container mt-5">
    <div class="card shadow-lg">
        <h2 class="text-center mb-4">Edit Cart</h2>
        
        <form action="updatecart" method="post">
            <div class="mb-3">
                <label class="form-label">Quantity:</label>
                <input type="number" name="quantity" value="${cart.quantity}" class="form-control">
            </div>
            
            <input type="hidden" name="cartId" value="${cart.cartId}"/>
            
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update Cart</button>
            </div>
        </form>
       <div class="back-link">
            <a href="listcart">← Back </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
