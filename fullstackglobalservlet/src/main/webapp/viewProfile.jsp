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
if(fb!=null) {
			out.println("Your profile is  ");
			out.println("<br>Name is "+fb.getFirstName());
			out.println("<br> Password is "+fb.getPassword());
			out.println("<br>Email is "+fb.getEmail());
			out.println("<br> Address is "+fb.getAddress());
		}
		else {
			out.println("profile not found");
		}
%>
  </div>
</div>


</body>
</html>