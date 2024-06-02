
<%@ page import="controller.Dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/crownstyle/crownnavbar.css">
</head>
<body>
    <header>
        <input type="checkbox" name="" id="chk1">
        <div class="logo"><h1>Crown</h1></div>
        <div class="search-box">
            <form action="">
                <input type="text" name="search" id="srch" placeholder="Search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="${ pageContext.request.contextPath }/viewpage/userproduct.jsp">Products</a></li>
			<% 
                String usermail = (String) session.getAttribute("usermail");
                if (usermail != null && !usermail.isEmpty()) {
                    // Fetch user's first name from the database using UserDao
                    String userName = (String) session.getAttribute("userName");
            %>
                <li><a href="viewpage/crownprofile.jsp"><%= userName %> Profile</a></li>
            <% } %>
            <li><a href="#">Contact us</a></li>
        </ul> 
    </header>
    
</body>
</html>
