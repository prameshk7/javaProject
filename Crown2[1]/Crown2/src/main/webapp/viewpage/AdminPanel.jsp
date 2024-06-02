<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"> 
<title>Insert title here</title>
</head>
<style>
	body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
  }
  
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }
  
  .profile {
    margin-bottom: 20px;
  }
  

  .fa-solid, .fas {
    font-weight: 900;
    font-size: 100px;
}



  .profile img {
    width: 100px; 
    height: 100px; 
    
  }
  
  .buttons {
    display: flex;
    justify-content: center; 
    margin-top: 20px; 
  }
  
  .buttons button {
    width: 200px;
    height: 200px;
    margin: 0 10px; 
    font-size: 18px;
    font-weight: bold;
    background-color: #3498db;
    border: none;
    border-radius: 10px;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
    
  }
  
  .buttons button:hover {
    background-color: #2980b9;
  }
  
  
</style>
<body>
	<div class="container">
    <div class="profile">
        <i class="fa-solid fa-user"></i>
    </div>
    <div class="buttons">
       <a href="<%=request.getContextPath() %>/viewpage/displayProduct.jsp"><button>List of Products</button></a>
       <a href="${ pageContext.request.contextPath }/viewpage/AddProduct.jsp"><button>Add Products</button></a>
       <a href="${ pageContext.request.contextPath }/viewpage/OrderHistory.jsp"><button>Order History</button></a>
    </div>
  </div>
</body>
</html>