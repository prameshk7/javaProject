<%@ page import="controller.Dao.UserDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

#upload-profile-form {
    background-color: #fff;
    padding: 60px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 700px;
    width: 100%;
}

h2 {
    color: #333;
    margin-bottom: 30px;
}

.form-group {
    margin-bottom: 15px;
    text-align: left;
}

label {
    display: block;
    margin-bottom: 5px;
    color: #555;
}

input[type="text"],
input[type="file"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    background-color: #ccc;
}

input[type="text"]::placeholder {
    color: black; 
}

.button-group {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 20px; 
}

.button-group:last-child {
    justify-content: center;
}

button[type="submit"] {
    margin-top: 50px; 

}


button[type="submit"],
button[type="reset"] {
    background-color:cornflowerblue;
    color: black;
    padding: 15px;
    border: none;
    cursor: pointer;
    width: 30%;
    transition: background-color 0.3s ease;
}


button[type="reset"] {
    background-color: #ccc;
}

.profile-heading {
    display: flex;
    align-items: center;
    margin-bottom: 30px;
}

.person-icon {
    width: 30px;
    height: 30px;
    margin-right: 10px;
}

.profile-label {
    display: inline-block;
    position: relative;
    margin-bottom: 20px;
    color: black;
}

.profile-label::after {
    content: "";
    position: absolute;
    left: 0;
    bottom: -10px;
    width: 1400%;
    height: 1px;
    background-color: #333; /* color of the underline */
}

.update {
    height: 20px;
}
</style>

</head>
<body>
<%
    String usermail = (String) session.getAttribute("usermail");
    UserDao userDao = new UserDao();
    String userName = userDao.getuserName(usermail);
    String firstName = userDao.getfirstName(usermail);
    String lastName = userDao.getlastName(usermail);
%>


<form action="${pageContext.request.contextPath}/crownProfileEdit" method="post" id="upload-profile-form" enctype="multipart/form-data">
  <div class="form-group">
    <div class="profile-heading">
      <img src="${pageContext.request.contextPath}/crownstyle/logo.png"  alt="Person Icon" class="person-icon">
      <h2 class="update">Edit Profile</h2>
    </div>
    <label for="profile" class="profile-label">Profile:</label>
  </div>
    <div class="form-group">
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" value="<%= userName %>">
    </div>
    <div class="form-group">
        <label for="firstname">First Name:</label>
        <input type="text" id="firstname" name="firstname" value="<%= firstName %>">
    </div>
    <div class="form-group">
        <label for="lastname">Last Name:</label>
        <input type="text" id="lastname" name="lastname" value="<%= lastName %>">
    </div>
  <div class="form-group button-group">
    <input type="file" id="image" name="image" style="width: 32%;">
    <button type="reset" style="width: 32%;">Clear</button>
  </div>
  <div class="button-group">
    <button type="submit">Update</button>
  </div>
</form>
</body>
</html>