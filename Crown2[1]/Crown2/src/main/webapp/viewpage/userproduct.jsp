
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.productModel" %>
    <%@ page import="controller.Dao.UserDao" %>
	<%@ page import="controller.Dao.ProductDao" %>
	<%@ page import="java.util.List" %>
	
	
	
<%
String usermail = (String) session.getAttribute("usermail");
UserDao userDao = new UserDao();
String userId = userDao.getUserIdByEmail(usermail);
ProductDao productDao = new ProductDao();
List<productModel> productList = productDao.getAllProducts();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"> 
<title>Product page</title>
<style>

* {
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
    font-family: arial;
}

body {
    background-position: center;
    background-size: cover;
    height: 100vh;
    background-position: center;
    margin: 0; 
    padding: 0; 
    font-family: Arial; 
}

header {
    width: 100%;
    height: 75px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 99;
    box-shadow: 0 0 10px #000;
    background: rgba(0, 0, 0, 0.62);
}

#chk1 {
    display: none;
}

i {
    color: #fff;
    cursor: pointer;
}

header .logo {
    flex: 0.6;
    color: #fff;
    margin-left: 50px;
    text-transform: uppercase;
    font-size: 15px;
}

header .search-box {
    flex: 1.1;
    position: relative;
}

.search-box input {
    width: 100%;
    height: 40px;
    border: none;
    outline: none;
    background: #f2f2f2;
    border-radius: 30px;
    color: rgb(73, 80, 71);
    font-size: 16px;
    text-align: center;
    padding-left: 5px;
}

.search-box button {
    cursor: pointer;
    width: 40px;
    height: 40px;
    border-radius: 30px;
    border: none;
    position: absolute;
    top: 0;
    right: 0;
    transform: scale(0.9);
    background: rgb(108, 104, 104);
}

header ul {
    flex: 2;
    display: flex;
    justify-content: space-evenly;
}

header ul li {
    list-style: none;
}

header ul li a {
    text-decoration: none;
    color: #fff;
    font-weight: 600;
    text-transform: uppercase;
    padding: 10px 15px;
}

header ul li a:hover {
    border-bottom: 2px solid gray;
}

header .menu {
    font-size: 2.5em;
    display: none;
}

@media(max-width: 1000px) {
    .search-box button {
        position: absolute;
    }

    header ul {
        position: fixed;
        top: 100px;
        right: -100%;
        background: rgba(0, 0, 0, 0.5);
        height: calc(100vh - 100px);
        width: 50%;
        flex-direction: column;
        align-items: center;
        transition: right 0.5s linear;
    }

    header .menu {
        display: block;
        width: 100px;
        text-align: center;
    }

    #chk1:checked~ul {
        right: 0;
    }
}

@media(max-width: 600px) {
    header .logo {
        font-size: 10px;
        margin-left: 8px;
    }

    header ul {
        width: 100%;
    }

    .search-box input {
        font-size: 14px; 
    }

    .search-box button {
        width: 30px; 
        height: 30px; 
    }
}







.popup {
    position: absolute;
    background-color: rgb(42, 43, 42);
    padding: 10px;
    border-radius: 5px;
    display: none;
    top: 70px;
    z-index: 1;
    right: 1px;
    width: 160px;
    height: 170px;
}

.popup ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    display: block; 
}

.popup ul li {
    padding: 5px 0; 
}

.popup ul li a {
    color: white;
    text-decoration: none;
    display: block;
    margin-left: 5px; 
}

.popup ul li a i {
    margin-right: 5px; 
}

  











* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    background-color: #f0e8e8;
    
}

.products-container {
    display: flex;
    margin-left: 273px;
    flex-wrap: wrap;
    justify-content: flex-start;
    padding: 50px;
    margin-top: -22px;
}

.product {
    background-color: white;
    border-radius: 0px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin: 18px;
    padding: 60px;
    width: 300px;
    height: 300px;
    text-align: center;
    margin-bottom: 10px;
}

.product img {
    width: 150px;
    height: 150px;
    border-radius: 5px;
    margin-bottom: 10px;
}

.product h2 {
    font-size: 20px;
    margin-bottom: 10px;
}

.product p {
    color: #888;
    font-size: 16px;
    margin-bottom: 15px;
}

.quantity-input {
    padding: 5px 20px;
    text-align: center;
    margin-right: -51px;
    border-radius: 5px;
    background-color: #4CAF50;
    color: white;
    border: none;    
    cursor: pointer;
    transition: background-color 0.3s;
}

.add-to-cart {
    background-color: #4CAF50;
    color: white;
    padding: 5px 20px;
    margin-left: -46px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.add-to-cart:hover {
    background-color: #45a049;
}


















.category-box {
    position: absolute;
    top: 118px; 
    left: 20px; 
    width: 250px;
    height: calc(70% - 118px); 
    background-color: rgb(254, 250, 250);
    padding: 20px;
    border-radius: 26px;
    overflow-y: auto; 
    z-index: 99; 
}


.category-box h2 {
    font-size: 24px;
    margin-bottom: 20px;
    margin-left: 37px;
}

.category-box .brands,
.category-box .price-adjuster {
    margin-bottom: 20px;
}

.category-box h3 {
    font-size: 18px;
    margin-bottom: 10px;
}

.category-box input[type="checkbox"] {
    display: block;
    margin-right: 5px;
}

.category-box input[type="range"] {
    width: 100%;
}

.category-box output {
    display: block;
    text-align: center;
    margin-top: 5px;
}



.category-box label {
    display: flex; 
    align-items: center; 
    margin-bottom: 5px; 
}

.container {
     display: flex;
     justify-content: space-between;
     align-items: center;
     margin-bottom: 10px; /* Add some margin below the container */
 }
  </style>
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
        <li><a href="#">Products</a></li>
        <li><a href="#">Contact us</a></li>
        <li><a href="${pageContext.request.contextPath}/viewpage/Cart.jsp"><i class="fa-solid fa-cart-shopping"></i></a></li>
        <li><i id="profile-link" class="fa-solid fa-user"></i></li>
    </ul> 
</header>
<div class="products-container">
   <%
   for (productModel prod : productList){
   %>
    <div class="product">
        <img src="<%=request.getContextPath() %>/<%=prod.getProductImgUrl() %>" alt="Product 1">
        <h2><%=prod.getProductName() %></h2>
        <p></p>
        <!-- User id dinu xa -->
        <div class="container">
        
	        <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
	        	<input type="hidden" name="prodId" value="<%=prod.getProductId() %>">
	        	<input type="hidden" name="userId" value="<%=userId %>">
		       	<button class="add-to-cart" type="submit" >Add to Cart</button>
	        </form>
	        <button class="quantity-input">View more</button>
        </div>
    </div>
    <%
   	}%>
    <div class="category-box">
    <h2>Categories</h2>
    <div class="brands">
        <h3>Brand: </h3>
        <label><input type="checkbox" name="brand" value="hp"> HP</label>
        <label><input type="checkbox" name="brand" value="asus"> Asus</label>
        <label><input type="checkbox" name="brand" value="acer"> Acer</label>
    </div>
    <div class="price-adjuster">
        <h3>Price: </h3>
        <input type="range" min="0" max="500000" value="1000" step="10" id="priceRange">
        <output for="priceRange" id="priceOutput">Rs1000</output>
    </div>
</div>
</div>


<script>
    document.addEventListener("DOMContentLoaded", function() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"][name="brand"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            checkboxes.forEach(function(cb) {
                if (cb !== checkbox) {
                    cb.checked = false;
                }
            });
        });
    });
});
</script>
    
</body>
</html>