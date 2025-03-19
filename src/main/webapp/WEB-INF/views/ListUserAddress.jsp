<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>List UserAddress</title>

<jsp:include page="AdminCss.jsp"></jsp:include>

<link href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>List UserAddress</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                <li class="breadcrumb-item active">List UserAddress</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">User Address<span>/all</span></h5>

                        <div class="table-responsive">
                            <table class="table datatable datatable-table table-hover" id="userAddress">
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
                                        <th>AddressDetail</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${allUserAddress}" var="u">
                                        <tr>
                                            <td data-label="FirstName">${u[13]}</td>
                                            <td data-label="LastName">${u[14]}</td>
                                            <td data-label="Title">${u[6]}</td>
                                            <td data-label="UnitName">${u[7]}</td>
                                            <td data-label="Street">${u[5]}</td>
                                            <td data-label="LandMark">${u[3]}</td>
                                            <td data-label="ZipCode">${u[9]}</td>
                                            <td data-label="CityName">${u[11]}</td>
                                            <td data-label="StateName">${u[12]}</td>
                                            <td data-label="AddressDetail">${u[10]}</td>
                                            <td>
                                                <div class="d-flex gap-2">
                                                    <a href="viewuseraddress?userAddressId=${u[0]}" class="btn btn-sm btn-primary">View</a>
                                                    <a href="deleteuseraddress?userAddressId=${u[0]}" class="btn btn-sm btn-danger">Delete</a>
                                                    <a href="edituseraddress?userAddressId=${u[0]}" class="btn btn-sm btn-warning">Edit</a>
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
        let table = new DataTable('#userAddress');
    });
</script>

</body>
</html>