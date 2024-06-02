<%@page import="model.UserModel"%>
<%@page import="util.crownStringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/crownstyle/crownlogin.css">
</head>
<body>
    <div class=" flex-r container">
        <div class="flex-r login-wrapper">
            <div class="login-text">
            <div class="logo">
            <img src="${pageContext.request.contextPath}/crownstyle/logo.png" alt="Crown Logo">
        	</div>
                <h1>Login Form</h1>
                
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
                
                
                <form class="flex-c" action="${pageContext.request.contextPath}/crownLogin" method="post">
                    <div class="input-box">
                        <span class="label">Email</span>
                        <div class=" flex-r input">
                            <input type="email" id="email" name="email" placeholder="Enter your email">
                        </div>
                    </div>
                    
                    <div class="input-box">
                        <span class="label">Password</span>
                        <div class="flex-r input">
                            <input type="password" id="password" name="password" placeholder="Enter password">
                        </div>
                    </div>

                    <input class="btn" type="submit" value="Login">
                    <p class="text-center mt-3">Don't have an account? <a href="${pageContext.request.contextPath}/viewpage/crownregister.jsp">SignUp here</a></p>
                </form>
            </div>
        </div>
    </div>
</body>

</html>




