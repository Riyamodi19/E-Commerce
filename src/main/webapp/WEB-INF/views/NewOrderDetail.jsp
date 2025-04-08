<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">      
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS (Same as Area Form) -->
    
         <jsp:include page="AdminCss.jsp"></jsp:include>
    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .form-container {
            background: white;
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            margin-top: 90px;
            margin-bottom: 100px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: 600;
            color: #333;
        }

        .form-label {
            font-weight: 500;
            margin-bottom: 8px;
            display: block;
            color: #444;
        }

        .form-control, .form-select {
            width: 100%;
            padding: 10px 15px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 12px;
            transition: border-color 0.3s ease;
        }

        .form-control:focus, .form-select:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }

        .btn-submit {
            width: 100%;
            padding: 12px;
             background: linear-gradient(135deg, #0357AF, #0180CC);  
            color: white;
            font-weight: 600;
            border: none;
            border-radius: 50px;
            transition: background 0.3s ease;
        }

        .btn-submit:hover {
            background: linear-gradient(135deg, #024A96, #0172B8);  
        }

        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            color: #667eea;
            text-decoration: none;
            font-weight: 500;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body style="background: #E5E8E9;">

     <jsp:include page="AdminHeader.jsp"></jsp:include>
     <jsp:include page="AdminSidebar.jsp"></jsp:include>
     
    <div class="form-container">
        <h2>Order Details</h2>

        <form action="saveorderdetail" method="post">

            <!-- Quantity -->
            <label class="form-label" for="quantity">Quantity</label>
            <input type="number" name="quantity" id="quantity" class="form-control" placeholder="Enter Quantity" required>

            <!-- Price -->
            <label class="form-label" for="price">Price</label>
            <input type="text" name="price" id="price" class="form-control" placeholder="Enter Price" required>

            <!-- Order Status -->
            <label class="form-label" for="status">Order Status</label>
            <select name="status" id="status" class="form-select" required>
                <option value="">-- Select Status --</option>
                <option value="Shipped">Shipped</option>
                <option value="Pending">Pending</option>
                <option value="Delivered">Delivered</option>
                <option value="Cancelled">Cancelled</option>
            </select>

            <!-- Product Dropdown -->
            <label class="form-label" for="productId">Product</label>
            <select name="productId" id="productId" class="form-select" required>
                <option value="">-- Select Product --</option>
                <c:forEach items="${allProduct}" var="s">
                    <option value="${s.productId}">${s.productName}</option>
                </c:forEach>
            </select>

      

            <!-- Submit Button -->
            <button type="submit" class="btn-submit">Save Order Detail</button>

        </form>

        <!-- Back Link -->
        <div class="back-link">
            <a href="listorderdetail">← Back </a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>