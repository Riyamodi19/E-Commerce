<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit State</title>
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">   
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Custom CSS -->
         <jsp:include page="AdminCss.jsp"></jsp:include>
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 90px;
            margin-bottom: 100px;
        }
        .card {
            border-radius: 10px;
            background: #fff;
            padding: 20px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            margin-top: 90px;
            margin-bottom: 100px;
        }
        .form-label {
            font-weight: bold;
            font-size: 18px;
        }
        .btn-submit {
            width: 40%;
            padding: 10px;
            background: linear-gradient(135deg, #0357AF, #0180CC);            
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            transition: background 0.3s ease;
        }
        .btn-submit:hover {
         background: linear-gradient(135deg, #024A96, #0172B8);       
            color: #e6e6fa;
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
            color: #8b008b;
        }
    </style>
</head>

<body style="background: #D6DFE9; display: flex; justify-content: center; align-items: center; height: 100vh;">

 <jsp:include page="AdminHeader.jsp"></jsp:include>
     <jsp:include page="AdminSidebar.jsp"></jsp:include>
     
<div class="container mt-5">
    <div class="card shadow-lg">
        <h2 class="text-center mb-4">Edit State</h2>

        <form action="updatestate" method="post">
            <!-- State Name -->
            <div class="mb-3">
                <label class="form-label" for="stateName">State Name</label>
                <input type="text" name="stateName" id="stateName" class="form-control" value="${state.stateName}" required>
            </div>

            <!-- Hidden State ID -->
            <input type="hidden" name="stateId" value="${state.stateId}"/>

            <!-- Submit Button Centered -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update State</button>
            </div>
        </form>

        <!-- Back Link -->
        <div class="back-link">
            <a href="liststate">← Back</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
