<%@page import="model.UserModel"%>
<%@page import="util.crownStringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crown Registration</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/crownstyle/crownregister.css">
</head>
<body>
<div class="container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/crownstyle/logo.png" alt="Crown Logo">
        </div>
	    <h2>Registration Form</h2>
	    <%
        String errorMessage = (String) request.getAttribute(crownStringUtils.ERROR_MESSAGE);
	    
        if (errorMessage !=null && !errorMessage.isEmpty()) {
	    %>
	        <div class="alert alert-danger" role="alert">
	            <%= errorMessage %>
	        </div>
	    <% 
	      }
	    %>
	    
	    
                    
	    <form action="${pageContext.request.contextPath}/crownRegister" method="post">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" id="userName" name="userName" placeholder="Choose a unique Username">
            </div>
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" id="firstName" name="firstName" placeholder="Enter Your First Name">
            </div>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input type="text" id="lastName" name="lastName" placeholder="Enter Your Last Name">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter Your Email Address">
            </div>
            <div class="form-group">
                <label for="password">Choose a Password</label>
                <input type="password" id="password" name="password" placeholder="Enter Your Password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Your Password</label>
                <input type="password" id="confirmpass" name="confirmpass" placeholder="Enter Your Password Again">
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        <p class="text-center mt-3">Already have an account? <a href="${pageContext.request.contextPath}/viewpage/crownlogin.jsp">Login here</a></p>
    </div>
</body>
</html>





