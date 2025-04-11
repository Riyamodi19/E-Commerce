<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="en">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Edit User</title>
 <jsp:include page="AdminCss.jsp"></jsp:include>
  
  <!-- Bootstrap CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>
 
     <!-- Custom CSS (Same as Edit Area) -->
     <style>
         body {
             background-color: #f8f9fa;
             display: flex;
             justify-content: center;
             align-items: center;
             min-height: 100vh;
             margin: 0;
         }
         .container {
             max-width: 600px;
         }
         .card {
             border-radius: 10px;
             background: #fff;
             padding: 20px;
         }
         .form-label {
             font-weight: bold;
             font-size: 18px;
         }
         .btn-submit {
             width: 30%;
             padding: 9px;
             background: linear-gradient(135deg, #0357AF, #0180CC);
             color: white;
             font-weight: bold;
             border: none;
             border-radius: 5px;
             transition: background 0.3s ease;
         }
         .btn-submit:hover {
             background: linear-gradient(135deg, #024A96, #0172B8);
              color:Lavender;
         }
         .back-link {
             margin-top: 15px;
             text-align: center;
         }
 
         .back-link a {
             color: #blue;
             text-decoration: none;
             font-weight: 630;
             font-size:19px;
         }
 
         .back-link a:hover {
             text-decoration: underline;
             color: #8B008B;
         }
         
     </style>
 
 </head>
 <body style="background: #C3CFDD">
 <jsp:include page="AdminHeader.jsp"></jsp:include>
 <jsp:include page="AdminSidebar.jsp"></jsp:include>
 <div class="container mt-5">
     <div class="card shadow-lg">
         <h2 class="text-center mb-4">Edit User</h2>
          <form action="updateuser" method="post">
          <!-- First Name -->
             <div class="mb-3">
                 <label class="form-label" for="firstName">First Name</label>
                 <input type="text" name="firstName" id="firstName" class="form-control" value="${user.firstName}" required>
             </div>
             
          <!-- Last Name -->
             <div class="mb-3">
                 <label class="form-label" for="lastName">Last Name</label>
                 <input type="text" name="lastName" id="lastName" class="form-control" value="${user.lastName}" required>
             </div>
             
          <!-- E-mail -->
             <div class="mb-3">
                 <label class="form-label" for="email">E-mail</label>
                 <input type="text" name="email" id="email" class="form-control" value="${user.email}" required>
             </div>
             
          <!-- Contact Number -->
             <div class="mb-3">
                 <label class="form-label" for="contactNum">Contact Number</label>
                 <input type="text" name="contactNum" id="contactNum" class="form-control" value="${user.contactNum}" required>
             </div>
             
          <!-- Gender -->
             <div class="mb-3">
                 <label class="form-label" for="gender">Gender</label>
                 <select name="gender" id="gender" class="form-control" required>
                     <option value="">-- Select Gender --</option>
                     <option value="male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
                     <option value="female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
                     <option value="other" ${user.gender == 'Other' ? 'selected' : ''}>Other</option>
                 </select>
             </div>
             
 		<!-- Hidden State ID -->
 		<input type="hidden" name="userId"  value="${user.userId}"/>
 		
 		<!-- Submit Button Centered -->
             <div class="d-flex justify-content-center">
                 <button type="submit" class="btn btn-submit hover">Update User</button>
             </div>
         </form>
         <!-- Back to Login Link -->
         <div class="back-link">
             <a href="listuser">← Back</a>
         </div>
 </div>
 </div>
 
 	</form>
 	<!-- Bootstrap JS -->
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
 	
 </body>
 </html>