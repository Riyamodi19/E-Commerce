<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">     
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Modern CSS (Same as Area Form) -->
         <jsp:include page="AdminCss.jsp"></jsp:include>
    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            
            height: auto;
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
            max-width: 700px;
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
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>

<body style="background: #E5E8E9;">

<jsp:include page="AdminHeader.jsp"></jsp:include>
     <jsp:include page="AdminSidebar.jsp"></jsp:include>

    <div class="form-container">
        <h2>Add Product</h2>

        <form action="saveproduct" method="post" enctype="multipart/form-data">

            <!-- Product Fields -->
            <label class="form-label" for="productName">Product Name</label>
            <input type="text" name="productName" id="productName" class="form-control" placeholder="Enter Product Name" required>

            
           <!-- Category Selection -->
            <label class="form-label" for="categoryId">Select Category</label>
            
            <select name="categoryId" id="categoryId" class="form-select" required onchange="getSubCategory()">
                <option value="-1">-- Select Category --</option>
                <c:forEach items="${allCategory}" var="s">
                    <option value="${s.categoryId}">${s.categoryName}</option>
                </c:forEach>
            </select>

            <!-- SubCategory Selection -->
            <label class="form-label" for="subCategoryId">Select Sub Category</label>
            <select name="subCategoryId" id="subCategoryId" class="form-select" required>
                <option value="-1">-- Select SubCategory --</option>
                
            </select>
            
            <label class="form-label" for="basePrice">Base Price</label>
            <input type="text" name="basePrice" id="basePrice" class="form-control" placeholder="Enter Base Price" required>

            <label class="form-label" for="offerPrice">Offer Price</label>
            <input type="text" name="offerPrice" id="offerPrice" class="form-control" placeholder="Enter Offer Price">

            <label class="form-label" for="offerPercentage">Offer Percentage</label>
            <input type="text" name="offerPercentage" id="offerPercentage" class="form-control" placeholder="Enter Offer Percentage">

            <label class="form-label" for="productDetail">Product Detail</label>
            <input type="text" name="productDetail" id="productDetail" class="form-control" placeholder="Enter Product Details">

            <label class="form-label" for="productImageURL1">Product Image URL 1</label>
            <input type="file" name="productImage1" id="productImageURL1" class="form-control" placeholder="Enter Image URL 1">
                          
            <label class="form-label" for="productImageURL2">Product Image URL 2</label>
            <input type="file" name="productImage2" id="productImageURL2" class="form-control" placeholder="Enter Image URL 2">

            <label class="form-label" for="productImageURL3">Product Image URL 3</label>
            <input type="file" name="productImage3" id="productImageURL3" class="form-control" placeholder="Enter Image URL 3">

            <label class="form-label" for="quantity">Quantity</label>
            <input type="number" name="quantity" id="quantity" class="form-control" placeholder="Enter Quantity" required>
            

            <!-- Submit Button -->
            <button type="submit" class="btn-submit">Save Product</button>

        </form>

        <!-- Back to Login Link -->
        <div class="back-link">
            <a href="listproduct">← Back </a>
        </div>
    </div>

     <script type="text/javascript">

	function getSubCategory(){
		console.log("category Change");
		let categoryId = document.getElementById("categoryId").value;
		console.log(categoryId);	
		//url -> json REST 
		
		  $.get( "getallsubcategorybycategoryid/"+categoryId, function() {
			})
			  .done(function(data) {
			    console.log(data);
			    //fill the subcategory 
			    $('#subCategoryId').empty().append('<option selected="selected" value="-1">-- Select SubCategory --</option>')
			    
			    for (var i = 0; i < data.length; i++) {
      			  $('#subCategoryId').append('<option value="' + data[i].subCategoryId + '">' + data[i].subCategoryName + '</option>');
   				 }
			    
			  })
			  .fail(function() {
			    alert( "error" );
			  })
			  
		
	}


</script> 
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>