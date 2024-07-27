<%@page import="com.fullstackglobalservlet.entity.MyEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Welcome <%= session.getAttribute("uid") %></a>
 

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="GlobalServlet?type=viewProfile">View Profile <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="GlobalServlet?type=editProfile">Edit Profile</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="GlobalServlet?type=searchProfile">Search Profile</a>
          <a class="dropdown-item" href="GlobalServlet?type=deleteProfile">Delete Profile</a>
          
          <a class="dropdown-item" href="GlobalServlet?type=viewAll">View All Profile</a>
          <a class="dropdown-item" href="GlobalServlet?type=logout">Logout</a>
        </div>
        
      </li>
      
    </ul>
    
  </div>
</nav>
<div class="card">
  <div class="card-body">
    <%
MyEntity fb=(MyEntity)request.getAttribute("result");
if(fb!=null) { %>
			<p> 
			<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/registrations/registration-6/assets/css/registration-6.css">
<!-- Registration 6 - Bootstrap Brain Component -->
<form action="GlobalServlet?type=registration" method="post">
<section class="bg-primary p-3 p-md-4 p-xl-5">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
        <div class="card border-0 shadow-sm rounded-4">
          <div class="card-body p-3 p-md-4 p-xl-5">
            <div class="row">
              <div class="col-12">
                <div class="mb-5">
                  <h2 class="h3">Edit Profile</h2>
                  <h3 class="fs-6 fw-normal text-secondary m-0">your old details is</h3>
                </div>
              </div>
            </div>
            <form action="#!">
              <div class="row gy-3 overflow-hidden">
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name" required value=<%= fb.getFirstName() %>>
                    <label for="firstName" class="form-label">First Name</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="First Name" required>
                    <label for="lastName" class="form-label">Last Name</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com" required value=<%=fb.getEmail() %>>
                    <label for="email" class="form-label">Email</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="password" id="password" value="" placeholder="Password" required value=<%=fb.getPassword() %>>
                    <label for="password" class="form-label">Password</label>
                  </div>
                </div>
                 <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="address" id="address" value="" placeholder="address" required value=<%=fb.getAddress() %>>
                    <label for="address" class="form-label">Address</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" name="iAgree" id="iAgree" required>
                    <label class="form-check-label text-secondary" for="iAgree">
                      I agree to the <a href="#!" class="link-primary text-decoration-none">terms and conditions</a>
                    </label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="d-grid">
                    <button class="btn bsb-btn-2xl btn-primary" type="submit">Edit</button>
                     <button class="btn bsb-btn-2xl btn-primary" type="reset">Reset</button>
                     <%= request.getAttribute("result1") %>
                  </div>
                </div>
              </div>
            </form>
            
           
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>

	<%	}
		else {
			out.println("profile not found");
		}
%>
  </div>
</div>


</body>
</html>