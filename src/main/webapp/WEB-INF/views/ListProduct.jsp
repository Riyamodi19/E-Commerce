<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>List Products</title>

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
        <h1>List Products</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                <li class="breadcrumb-item active">List Products</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Products<span>/all</span></h5>

                        <div class="table-responsive">
                            <table class="table datatable datatable-table table-hover" id="products">
                                <thead>
                                    <tr>
                                        <th>ProductName</th>
                                        <th>CategoryName</th>
                                        <th>SubCategoryName</th>
                                        <th>BasePrice</th>
                                        <th>OfferPrice</th>
                                        <th>OfferPercentage</th>
                                        <th>ProductDetail</th>
                                        <th>ProductImageURL1</th>
                                        <th>productImageURL2</th>
                                        <th>productImageURL3</th>
                                        <th>Quantity</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${allProduct}" var="p">
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
											<td>                                         
                                                <div class="d-flex gap-2">
                                                    <a href="viewproduct?productId=${p[0]}" class="btn btn-sm btn-primary">View</a>
                                                    <a href="deleteproduct?productId=${p[0]}" class="btn btn-sm btn-danger">Delete</a>
                                                    <a href="editproduct?productId=${p[0]}" class="btn btn-sm btn-warning">Edit</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="AdminFooter.jsp"></jsp:include>
<jsp:include page="AdminJs.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        let table = new DataTable('#products');
    });
</script>

</body>
</html>
