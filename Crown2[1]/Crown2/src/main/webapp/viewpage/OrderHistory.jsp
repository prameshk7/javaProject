<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="controller.Dao.OrderItemDao" %>
    <%@ page import="controller.Dao.ProductDao" %>
    <%@ page import="java.util.List" %>
    <%@ page import="model.OrderItemModel" %>
    <%@ page import="model.productModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    <h1>Order History</h1>
    <hr>
    <div class="product-container">
    <%
    OrderItemDao oDao = new OrderItemDao();
    ProductDao productDao = new ProductDao();
    List<OrderItemModel> order = oDao.getAllOrder();
    for (OrderItemModel o : order){
    	productModel product = productDao.getProductByProductId(o.getProductId());
   
    %>
      <div class="product">
        <div class="product-image">
          <img src="<%=request.getContextPath() %>/<%=product.getProductImgUrl() %>" alt="Product Image">
        </div>
        <div class="product-info">
          <h2><%=product.getProductName() %></h2>
          <p>Description: <%=product.getProductDesc() %>.</p>
          <p>Price: <%=o.getTotalPrice() %></p>
          <div class="order-details">
            <p>Quantity Ordered: <span class="quantity"><%=o.getQuantity() %></span></p>
            <p>Ordered Date: <span class="ordered-date"><%=o.getOrderDate() %></span></p>
            <label for="order-status">Order Status:</label>
            <select class="order-status" id="order-status" >
              <option value="pending">Pending</option>
              <option value="confirmed">Order Confirmed</option>
              <option value="delivered">Delivered</option>
            </select>
          </div>
          <div class="product-actions">
            <button class="update-button">Update</button>
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