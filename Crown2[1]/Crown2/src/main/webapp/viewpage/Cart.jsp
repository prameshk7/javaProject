<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    
    <%@ page import="model.productModel" %>
    <%@ page import="model.CartModel" %>
    <%@ page import="model.OrderItemModel" %>
	<%@ page import="controller.Dao.ProductDao" %>
	<%@ page import="controller.Dao.CartDao" %>
	<%@ page import="controller.Dao.OrderItemDao" %>
	<%@ page import="controller.Dao.UserDao" %>

<%
String usermail = (String) session.getAttribute("usermail");
UserDao userDao = new UserDao();
String userId = userDao.getUserIdByEmail(usermail);
ProductDao prodDao = new ProductDao();
CartDao cartDao = new CartDao();
OrderItemDao orderDao = new OrderItemDao();

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
    flex-wrap: wrap; 
    justify-content: center;
    margin-top: 20px;
  }
  
  .product {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 20px;
    width: calc(50% - 20px); 
    margin-bottom: 20px;
  
  }
  
  .product-image img {
    width: 115px;
    height: 120px;
  }
  
  .product-info {
    margin-top: -139px; 
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

  .History{
    margin-left: 1020px;
  }









.popup {
  display: none;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.popup-content {
  text-align: center;
}

.popup.show {
  display: block;
  margin-left: 221px;
  width: 625px;
  margin-top: -112px;
    
}

  







.order-history-card {
  display: flex;
  align-items: center;
  justify-content: space-between;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 10px;
}

.order-history-card > div {
  flex: 1;
}

.product-name {
  flex: 2; /* Adjust width as needed */
}

.quantity,
.price,
.date {
  flex: 1; /* Adjust width as needed */
  text-align: center;
}

</style>
<body>
	<div class="container">
    
    <h1>Cart</h1>
    <hr>


    <button class="History" onclick="togglePopup()">Order History</button>
    <div id="popup" class="popup">
      <div class="popup-content">
        <h2>Order History</h2>
    <%
    	List<OrderItemModel> orderList = orderDao.getOrderOfUser(userId);
    	for (OrderItemModel o : orderList){
    		productModel product = prodDao.getProductByProductId(o.getProductId());
    %>
        <div class="order-history-card">
          <div class="product-name"><%=product.getProductName() %></div>
          <div class="quantity"><%=o.getQuantity() %></div>
          <div class="price"><%=o.getTotalPrice() %></div>
          <div class="date"><%=o.getOrderDate() %></div>
          <div class="date"><%=o.getProductId() %></div>
        </div>
        <%
        }
        %>
        </div>
    </div>

  

        
        <script>
          function togglePopup() {
            var popup = document.getElementById("popup");
            popup.classList.toggle("show");
          }
        </script>


<%
List<CartModel> cart = cartDao.getCartByUser(userId);
for (CartModel c : cart){
	productModel product = prodDao.getProductByProductId(c.getProductId());
%>
    <div class="product-container">
      <div class="product">
        <div class="product-image">
          <img src="<%=request.getContextPath() %>/<%=product.getProductImgUrl() %>" alt="Product Image">
        </div>
        <div class="product-info">
          <h2><%=product.getProductName() %></h2>
          <p><%=product.getProductDesc() %></p>
          <p>Price: RS<%=c.getQuantity()* product.getProductPrice() %></p>
          <div class="quantity-adjuster">
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="<%=c.getQuantity() %>" min="1">
          </div>
          <div class="product-actions">
          <form action="${ pageContext.request.contextPath }/CartOperationServlet" method="post">
          	<input type="hidden" name="toDo" value="addOrder">
          	<input type="hidden" name="prodId" value="<%=product.getProductId() %>>">
          	<input type="hidden" name="userId" value="<%=userId %>>">
            <button class="update-button" type="submit">Order Now</button>
          
          </form>
          <form action="${ pageContext.request.contextPath }/CartOperationServlet" method="post">
			<input type="hidden" name="toDo" value="deleteCart">
			<input type="hidden" name="cartId" value="<%=c.getCartId() %>">          
            <button class="delete-button" type="submit">Delete</button>
          </form>
          </div>
        </div>
      </div>
    </div>
    <%
	}
    %>
  </div>
  
  <script type="text/javascript">
  function onChange(){
	var quantity = document.getElementById("quantity").value;
				  
  }
  
  
  </script>
</body>
</html>