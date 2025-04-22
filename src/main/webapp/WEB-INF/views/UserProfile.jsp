<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>User Profile </title>
  <meta content="" name="description">
  <meta content="" name="keywords">

<jsp:include page="AdminCss.jsp"></jsp:include>

 
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

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body style="background: #E5E8E9;">

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center" style="background: #8193AA;">

    <div class="d-flex align-items-center justify-content-between">
      <a href="home" class="logo d-flex align-items-center">
        <img src="ashion/images/icons/marsh.png" alt="">
        <span class="d-none d-lg-block">MRSH Ashion</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->
        
        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
             <img src="${user.profilePicPath}" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2">${user.firstName}</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>${user.firstName}&nbsp;${user.lastName}</h6>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="userprofile">
                <i class="bi bi-person"></i>
                <span>My Profile</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

           <!--  <li>
              <a class="dropdown-item d-flex align-items-center" href="userprofile">
                <i class="bi bi-gear"></i>
                <span>Account Settings</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>Need Help?</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
                -->
            <li>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <i class="bi bi-box-arrow-right"></i>
                <span>Sign Out</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  
<aside id="sidebar" class="sidebar" style="background: #E5E8E9;">
	<ul class="sidebar-nav" id="sidebar-nav" style="background: #A3B8D0;">

		<li class="nav-item">
			<a class="nav-link" href="admindashboard">
				<i class="bi bi-grid"></i> <span>Admin Dashboard</span>
			</a>
		</li>
		<!-- End Dashboard Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#users-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-person"></i><span>Users</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="users-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="signup"> <i class="bi bi-circle"></i><span>Add User</span></a></li>
				<li><a href="listuser"> <i class="bi bi-circle"></i><span>List User</span></a></li>
			</ul>
		</li>
		<!-- End Users Nav -->

		<!--  <li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#area-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-map"></i><span>Area</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="area-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="NewArea"> <i class="bi bi-circle"></i><span>Add Area</span></a></li>
				<li><a href="listArea"> <i class="bi bi-circle"></i><span>List Area</span></a></li>
			</ul>
		</li>-->
		<!-- End Area Nav -->
		

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#cart-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-cart"></i><span>Cart</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="cart-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newcart"> <i class="bi bi-circle"></i><span>Add Cart</span></a></li>
				<li><a href="listcart"> <i class="bi bi-circle"></i><span>List Cart</span></a></li>
			</ul>
		</li>
		<!-- End Cart Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#category-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-tags"></i><span>Category</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="category-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newcategory"> <i class="bi bi-circle"></i><span>Add Category</span></a></li>
				<li><a href="listcategory"> <i class="bi bi-circle"></i><span>List Category</span></a></li>
			</ul>
		</li>
		<!-- End Category Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#city-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-building"></i><span>City</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="city-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newcity"> <i class="bi bi-circle"></i><span>Add City</span></a></li>
				<li><a href="listcity"> <i class="bi bi-circle"></i><span>List City</span></a></li>
			</ul>
		</li>
		<!-- End City Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#orderdetail-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-journal-text"></i><span>OrderDetail</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="orderdetail-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="neworderdetail"> <i class="bi bi-circle"></i><span>Add OrderDetail</span></a></li>
				<li><a href="listorderdetail"> <i class="bi bi-circle"></i><span>List OrderDetail</span></a></li>
			</ul>
		</li>
		<!-- End OrderDetail Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#orders-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-cart-check"></i><span>Orders</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="orders-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="neworders"> <i class="bi bi-circle"></i><span>Add Orders</span></a></li>
				<li><a href="listorders"> <i class="bi bi-circle"></i><span>List Orders</span></a></li>
			</ul>
		</li>
		<!-- End Orders Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#product-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-box"></i><span>Product</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="product-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newproduct"> <i class="bi bi-circle"></i><span>Add Product</span></a></li>
				<li><a href="listproduct"> <i class="bi bi-circle"></i><span>List Product</span></a></li>
			</ul>
		</li>
		<!-- End Product Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#reviews-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-star"></i><span>Reviews</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="reviews-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newreviews"> <i class="bi bi-circle"></i><span>Add Reviews</span></a></li>
				<li><a href="listreviews"> <i class="bi bi-circle"></i><span>List Reviews</span></a></li>
			</ul>
		</li>
		<!-- End Reviews Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#state-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-geo-alt"></i><span>State</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="state-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newstate"> <i class="bi bi-circle"></i><span>Add State</span></a></li>
				<li><a href="liststate"> <i class="bi bi-circle"></i><span>List State</span></a></li>
			</ul>
		</li>
		<!-- End State Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#subcategory-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-list-ul"></i><span>SubCategory</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="subcategory-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newsubcategory"> <i class="bi bi-circle"></i><span>Add SubCategory</span></a></li>
				<li><a href="listsubcategory"> <i class="bi bi-circle"></i><span>List SubCategory</span></a></li>
			</ul>
		</li>
		<!-- End SubCategory Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#useraddress-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-house-door"></i><span>UserAddress</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="useraddress-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newuseraddress"> <i class="bi bi-circle"></i><span>Add UserAddress</span></a></li>
				<li><a href="listuseraddress"> <i class="bi bi-circle"></i><span>List UserAddress</span></a></li>
			</ul>
		</li>
		<!-- End UserAddress Nav -->

		<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#wishlist-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-heart"></i><span>Wishlist</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
			<ul id="wishlist-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
				<li><a href="newcity"> <i class="bi bi-circle"></i><span>Add Wishlist</span></a></li>
				<li><a href="listwishlist"> <i class="bi bi-circle"></i><span>List Wishlist</span></a></li>
			</ul>
		</li>
		<!-- End Wishlist Nav -->

		<li class="nav-heading">Manage</li>

		<li class="nav-item">
			<a class="nav-link" href="listseller"> <i class="bi bi-person"></i> <span>Seller</span> </a>
		</li>
		<!-- End Seller Nav -->

		<li class="nav-item">
			<a class="nav-link" href="home"> <i class="bi bi-house-door"></i> <span>Home</span> </a>
		</li>
		<!-- End Home Nav -->

	</ul>
</aside>
	<!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
          <li class="breadcrumb-item"><a href="listuser">Users</a></li>
          <li class="breadcrumb-item active"><a href="userprofile">Profile</a></li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

             <img src="${user.profilePicPath}" alt="Profile" class="rounded-circle">
              <h2>${user.firstName}&nbsp;${user.lastName}</h2>
              <div class="social-links mt-2">
                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                </li>

                
              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">

                  <h5 class="card-title">Profile Details</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Full Name</div>
                    <div class="col-lg-9 col-md-8">${user.firstName}&nbsp;${user.lastName}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone</div>
                    <div class="col-lg-9 col-md-8">${user.contactNum}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${user.email}</div>
                  </div>

                </div>

                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form>
                    <div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
            		  <img src="${user.profilePicPath}" alt="Profile" class="rounded-circle">
                        <div class="pt-2">
                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></a>
                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="fullName" type="text" class="form-control" id="fullName" value="${user.firstName}&nbsp;${user.lastName}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Phone</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" id="Phone" value="${user.contactNum}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="email" class="form-control" id="Email" value="${user.email}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Twitter" class="col-md-4 col-lg-3 col-form-label">Twitter Profile</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="twitter" type="text" class="form-control" id="Twitter" value="https://twitter.com/#">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Facebook" class="col-md-4 col-lg-3 col-form-label">Facebook Profile</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="facebook" type="text" class="form-control" id="Facebook" value="https://facebook.com/#">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Instagram" class="col-md-4 col-lg-3 col-form-label">Instagram Profile</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="instagram" type="text" class="form-control" id="Instagram" value="https://instagram.com/#">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Linkedin" class="col-md-4 col-lg-3 col-form-label">Linkedin Profile</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="linkedin" type="text" class="form-control" id="Linkedin" value="https://linkedin.com/#">
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">
               </div>
              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer" style="background: #E5E8E9;">
    <div class="copyright">
      &copy; Copyright <strong><span>MRSH</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      <!-- All the links in the footer should remain intact. -->
      <!-- You can delete the links only if you purchased the pro version. -->
      <!-- Licensing information: https://bootstrapmade.com/license/ -->
      <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/chart.js/chart.umd.js"></script>
  <script src="assets/vendor/echarts/echarts.min.js"></script>
  <script src="assets/vendor/quill/quill.js"></script>
  <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>
