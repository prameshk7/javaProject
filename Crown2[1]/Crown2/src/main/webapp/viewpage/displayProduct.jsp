<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@ page import="model.productModel" %>
	<%@ page import="controller.Dao.ProductDao" %>
	<%@ page import="java.util.List" %>
	
<%
ProductDao productDao = new ProductDao();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
</head>
<style>
	body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

.container {
  width: 80%;
  margin: 20px auto;
}

h1 {
  margin-top: 0;
}

hr {
  border: 1px solid #ccc;
}

.product-container {
  display: flex;
  flex-wrap: wrap; /* Added to ensure products wrap to the next line if needed */
  justify-content: center;
  margin-top: 20px;
}

.product {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  width: calc(50% - 20px); /* Changed to 50% width to accommodate two products per row with spacing */
  margin-bottom: 20px; /* Added margin bottom to create space between products */
}

.product-image img {
  width: 115px;
  height: 120px;
}

.product-info {
  margin-top: -139px; /* Adjusted margin-top to align with the product image */
  margin-left: 141px;
}

.product-actions {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

.product-actions button {
  margin-left: 10px;
  padding: 5px 10px;
  font-size: 14px;
  cursor: pointer;
}

.btn {
  color: #ffffff;
  border-radius: 30px;
  padding: 11px 17px;
  background: linear-gradient(122.33deg, #68bed1 30.62%, #1E94E9 100%);
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 16px;
  transition: all 0.3s linear;
}
</style>
<body>
	<div class="container">
    <h1>List of Products</h1>
    <hr>
    <div class="product-container">
    <%
    List<productModel> productList = productDao.getAllProducts();
    for (productModel prod : productList){
    
    %>
      <div class="product">
        <div class="product-image">
          <img src="<%=request.getContextPath() %>/<%=prod.getProductImgUrl() %>" alt="Product Image">
        </div>
        <div class="product-info">
          <h2><%=prod.getProductName() %>></h2>
          <p>Description: <%=prod.getProductDesc() %></p>
          <p>Price: RS<%=prod.getProductPrice() %></p>
          <p>Quantity: <%=prod.getStock() %></p>
          <p>Brand: <%=prod.getBrand() %></p>
          <div class="product-actions">
            <a href="ProductUpdate.jsp?prodId=<%=prod.getProductId() %>"><button class="update-button">Update</button></a>
            <form action="${pageContext.request.contextPath}/DeleteProductServlet" method="post">
    			<input type="hidden" name="prodId" value="<%=prod.getProductId()%>">
    			<button type="submit" class="delete-button">Delete</button>
			</form>
 		</div>
        </div>
      </div>

    <%
    }
    %>
    </div>
  </div>
</body>
</html>