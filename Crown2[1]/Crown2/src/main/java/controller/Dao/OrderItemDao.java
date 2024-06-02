package controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.crownStringUtils;
import model.OrderItemModel;

public class OrderItemDao {
	
	DatabaseConnection db = new DatabaseConnection();
	
	public boolean placeOrder(OrderItemModel order) {
		boolean flag = false;
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.INSERT_ORDER_ITEM);
			st.setString(1, order.getOrderId());
			st.setString(2, order.getProductId());
			st.setInt(3, order.getQuantity());
			st.setDouble(4, order.getTotalPrice());
			st.setDate(5, order.getOrderDate());
			st.setString(6, order.getStatus());
			st.setString(7, order.getUserID());
			
			flag = st.execute();
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<OrderItemModel> getAllOrder(){
		List<OrderItemModel> list = new ArrayList<OrderItemModel>();
		try {
			Connection con = db.getConnection();
			Statement st = con.createStatement();
			
			ResultSet table = st.executeQuery(crownStringUtils.GET_ALL_ORDER);
			while(table.next()) {
				String orderId = table.getString("order_id");
				String productId = table.getString("product_id");
				int quantity = table.getInt("quantity");
				double totalPrice = table.getDouble("total_price");
				Date orderDate = table.getDate("order_date");
				String status = table.getString("status");
				String userId = table.getString("user_id");
				
				OrderItemModel order = new OrderItemModel(orderId, productId, quantity, totalPrice, orderDate, status, userId);
				list.add(order);
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<OrderItemModel> getOrderOfUser(String uid){
		List<OrderItemModel> list = new ArrayList<OrderItemModel>();
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_USER_ORDER);
			st.setString(1, uid);
			
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String orderId = table.getString("order_id");
				String productId = table.getString("product_id");
				int quantity = table.getInt("quantity");
				double totalPrice = table.getDouble("total_price");
				Date orderDate = table.getDate("order_date");
				String status = table.getString("status");
				String userId = table.getString("user_id");
				
				OrderItemModel order = new OrderItemModel(orderId, productId, quantity, totalPrice, orderDate, status, userId);
				list.add(order);
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateStatus(String oid, String prompt) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.UPDATE_ORDER_STATUS);
			st.setString(1, prompt);
			st.setString(2, oid);
			
			int row = st.executeUpdate();
			
			if(row >= 1) {
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
