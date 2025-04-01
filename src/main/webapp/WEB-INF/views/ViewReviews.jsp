<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>View Reviews</title>

 <jsp:include page="AdminCss.jsp"></jsp:include>
 
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<link href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

</head>
<body style="background: #E5E8E9;">

<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>View Reviews</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="listreviews">Home</a></li>
                <li class="breadcrumb-item active">View Reviews</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Reviews<span>/all</span></h5>

                        <table class="table datatable datatable-table table-hover" id="reviews">
                            <thead>
                                <tr>
                                     <th>First Name</th>
							         <th>Last Name</th>
							         <th>Product Name</th>
							          <th>Review Text</th>
							          <th>Rating</th>

                                </tr>
                            </thead>
                            <tbody>
					                <c:forEach items="${reviews}" var="r">
				                    <tr>
				                        <td>${r[6]}</td>
									    <td>${r[7]}</td>
									    <td>${r[8]}</td>
										<td>${r[3]}</td>
										<td>${r[4]}</td>
				
				                    </tr>
				                </c:forEach>

                            </tbody>
                        </table>
                        <div class="text-center">
                       <a href="listreviews" class="btn btn-primary btn-back">
                       <i class="bi bi-arrow-left"></i> Back
            </a>
        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="AdminFooter.jsp"></jsp:include>
<jsp:include page="AdminJs.jsp"></jsp:include>

<!--  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>-->

<script type="text/javascript">
    $(document).ready(function() {
        let table = new DataTable('#reviews');
    });
</script>

</body>
</html>