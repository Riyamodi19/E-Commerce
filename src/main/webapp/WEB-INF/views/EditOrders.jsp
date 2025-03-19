<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Orders</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Custom CSS (Styled like Edit Cart) -->
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
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
            font-size: 21px;
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

<body>

<div class="container mt-5">
    <div class="card shadow-lg">
        <h2 class="text-center mb-4">Edit Orders</h2>

        <form action="updateorders" method="post">
            <!-- Total Amount -->
            <div class="mb-3">
                <label class="form-label" for="totalAmount">Total Amount</label>
                <input type="text" name="totalAmount" id="totalAmount" class="form-control" value="${orders.totalAmount}" required>
            </div>

            <!-- Order Status -->
            <div class="mb-3">
                <label class="form-label" for="status">Order Status</label>
                <select name="status" id="status" class="form-control" required>
                    <option value="">-- Select Status --</option>
                    <option value="Shipped" ${orders.status == 'Shipped' ? 'selected' : ''}>Shipped</option>
                    <option value="Pending" ${orders.status == 'Pending' ? 'selected' : ''}>Pending</option>
                    <option value="Delivered" ${orders.status == 'Delivered' ? 'selected' : ''}>Delivered</option>
                    <option value="Cancelled" ${orders.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
                </select>
            </div>

            <!-- Hidden Order ID -->
            <input type="hidden" name="orderId" value="${orders.orderId}"/>

            <!-- Submit Button Centered -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update Orders</button>
            </div>
        </form>

        <!-- Back Link -->
        <div class="back-link">
            <a href="listorders">← Back</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
    
<!--  <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Orders</title>
</head>
<body>
<body>
	<h2>Edit Orders</h2>
	<form action="updateorders" method="post">
		Total Amount:<input type="text" name="totalAmount" value="${orders.totalAmount}"><br><br>
		Order Status : <select name="status" id="status" value="${orders.status}" required>
                <option value="">-- Select Status --</option>
                <option value="Shipped">Shipped</option>
                <option value="Pending">Pending</option>
                <option value="Delivered">Delivered</option>
                <option value="Cancelled">Cancelled</option>
            </select><br><br>
   	 	<input type="hidden" name="orderId"  value="${orders.orderId}"/>

		<input type="submit" value="Update Orders">

	</form>

</body>-->