<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.productModel" %>
	<%@ page import="controller.Dao.ProductDao" %>
	
<%
String prodId = request.getParameter("prodId");
productModel product = new ProductDao().getProductByProductId(prodId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f2f2f2;
    }

.container {
  width: 50%;
  margin: 0 auto;
}

h4 {
  text-align: center;
  margin-bottom: 20px;
}

label {
  font-weight: bold;
}

input[type="text"], input[type="file"], button {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}

input[type="file"] {
  border: none;
  background-color: #f0f0f0;
  cursor: pointer;
}

button[type="submit"], button[type="reset"] {
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button[type="submit"]:hover, button[type="reset"]:hover {
  background-color: #45a049;
}

.form-group {
  display: flex;
  justify-content: space-between;
}

.post-button {
  width: 48%;
}
.existing-product-image {
  width: 50px; 
  height: 50px; 
  margin-bottom: 10px;
}

@media screen and (max-width: 600px) {
  .container {
    width: 80%;
  }
}
  
	
</style>
</head>
<body>
<div class="container">
    <h4>Update Product</h4>
  <form action="${pageContext.request.contextPath }/UpdateProductServlet?prodId=<%=prodId %>" method="post" enctype="multipart/form-data">  
    
   <label for="productName">Enter product name:</label>
    <br> 
    <input type="text" name="productName" placeholder="Product name" class="product-name-input" value="<%=product.getProductName() %>">
    <label for="productName">Enter product description:</label>
    <br> 
    <input type="text" name="productDesc" placeholder="Product Desc" class="product-name-input" value="<%=product.getProductDesc() %>">
    <label for="productPrice">Enter price:</label>
    <br> 
    <input type="text" name="productPrice" placeholder="Enter price" class="product-price-input" value="<%=product.getProductPrice() %>">
    <label for="productQuantity">Enter quantity:</label>
    <br> 
    <input type="text" name="productQuantity" placeholder="Enter quantity" class="product-quantity-input" value="<%=product.getStock() %>">
    <label for="productQuantity">Enter Brand:</label>
    <br> 
    <input type="text" name="productBrand" placeholder="Enter Brand" class="product-quantity-input" value="<%=product.getBrand() %>">
  <div class="form-group button-group">
    <input class="post-button" type="file" id="photo" name="photo" style="width: 32%;">
    <img src="<%=request.getContextPath() %>/<%= product.getProductImgUrl() %>" alt="Product Image" class="existing-product-image">
  </div>
    <button class="post-button" type="submit">Update</button>
  </form>
</div>
</body>
</html>