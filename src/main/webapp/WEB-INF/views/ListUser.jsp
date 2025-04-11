
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>List User</title>

<jsp:include page="AdminCss.jsp"></jsp:include>
<!-- Favicons -->
<link href="ashion/images/icons/marsh.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<link href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

<!-- Custom Styles -->
<style>
    td:last-child {
        white-space: nowrap; /* Prevent text wrapping in action column */
    }
</style>

</head>
<body style="background: #E5E8E9;">

<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>List User</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                <li class="breadcrumb-item active">List User</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">User<span>/all</span></h5>

                        <table class="table datatable datatable-table table-hover" id="users">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Contact Number</th>
                                    <th>Gender</th>
                                    <th>Created At</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${userList}" var="u">
                                    <tr>
                                        <td>${u.firstName}</td>
                                        <td>${u.lastName}</td>
                                        <td>${u.email}</td>
                                        <td>${u.contactNum}</td>
                                         <td>${u.gender}</td>
                                        <td>${u.createdAt}</td>
                                        <td>
                                            <div class="d-flex gap-2">
                                                <a href="viewuser?userId=${u.userId}" class="btn btn-sm btn-primary">View</a>
                                                <a href="deleteuser?userId=${u.userId}" class="btn btn-sm btn-danger">Delete</a>
                                                <a href="edituser?userId=${u.userId}" class="btn btn-sm btn-warning">Edit</a>
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
    </section>
</main>

<jsp:include page="AdminFooter.jsp"></jsp:include>
<jsp:include page="AdminJs.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        let table = new DataTable('#users');
    });
</script>

</body>
</html>
