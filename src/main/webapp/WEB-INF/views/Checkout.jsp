<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <jsp:include page="AdminCss.jsp"></jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">

    <!-- Optional: Include FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>

   <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            max-width: 400px;
            width: 100%;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        label {
            font-weight: 500;
            display: block;
            margin: 10px 0 5px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            box-sizing: border-box;
            margin-bottom: 15px;
        }

        input[readonly] {
            background-color: #f0f0f0;
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

        @media (max-width: 480px) {
            .form-container {
                padding: 20px;
            }

            input[type="text"],
            input[type="submit"] {
                font-size: 15px;
            }
        }
    </style>
</head>
<body  style="background: #E5E8E9;">
<div class="container">

        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

<div class="d-flex justify-content-center py-4">
                <a href="signup" class="logo d-flex align-items-center w-auto">
                 <img src="ashion/images/icons/marsh.png" alt="">
                  <span class="d-none d-lg-block">MRSH Ashion</span>
                </a>
              </div><!-- End Logo -->
<div class="form-container">

    <h2>Payment Details</h2>
    <form action="pay" method="post">
        <label>Amount</label>
        <input type="text" readonly="readonly" value="${amount}"/>

        <label>Credit Card</label>
        <input type="text" size="16" name="ccNum" placeholder="1234 5678 9012 3456"/>

        <label>Expiration Date</label>
        <input type="text" name="expDate" size="4" placeholder="MMYY"/>

        <input type="submit" class="btn btn-submit hover" value="Pay"/>
    </form>
</div>
</div></div></div></div>
</body>
</html>