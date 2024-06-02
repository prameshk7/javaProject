package controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.crownStringUtils;
import model.CartModel;


public class CartDao {
	
	DatabaseConnection db = new DatabaseConnection(); 
	
	public boolean addToCart(CartModel cart) {
		boolean falg = false;
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.INSERT_CART);
			st.setString(1, cart.getCartId());
			st.setString(2, cart.getUserId());
			st.setString(3, cart.getProductId());
			st.setInt(4, cart.getQuantity());
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
				falg = true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return falg;
	}
	
	public List<CartModel> getCartByUser(String uid){
		List<CartModel> list = new ArrayList<CartModel>();
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_CART);
			st.setString(1, uid);
			
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String cartId = table.getString("cart_id");
				String productId = table.getString("product_id");
				int quantity = table.getInt("quantity");
				
				CartModel cart = new CartModel(cartId, uid, productId, quantity);
				list.add(cart);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		
		return list;
	}
	
	public int getQuantity(String uid, String proId) {
		int quantity = 0;
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_CART_QUANTITY);
			st.setString(1, uid);
			st.setString(2, proId);
			
			ResultSet table = st.executeQuery();
			table.next();
			quantity = table.getInt("quantity");
				
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return quantity;
	}
	
	public void updateQuantity(String cartId, int quantity) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.UPDATE_CART_QUANTITY);
			st.setString(1, cartId);
			st.setInt(2, quantity);
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
				
			}
				
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeCart(String cartId) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.DELETE_CART);
			st.setString(1, cartId);
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
				
			}
				
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeAllCart() {
		try {
			Connection con = db.getConnection();
			Statement st = con.createStatement();
			
			
			int row = st.executeUpdate(crownStringUtils.DELETE_ALL_CART);
			
			if (row >= 1) {
				
			}
				
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getCartCountOfUser(String uid) {
		int count = 0;
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_USER_CART_COUNT);
			st.setString(1, uid);
			
			ResultSet table = st.executeQuery();
			table.next();
			count = table.getInt("cart_count");
				
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public String cartId(String uid, String proId) {
		String cartId = "";
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_CART_ID);
			st.setString(1, uid);
			st.setString(2, proId);
			
			ResultSet table = st.executeQuery();
			table.next();
			cartId = table.getString("cart_id");
			
		}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		
		return cartId;
	}
	
	public List<String> getProductId(String cartId) {
		List<String> list = new ArrayList<String>();
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_CART);
			st.setString(1, cartId);
			
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String prodId = table.getString("product_id");
				
				list.add(prodId);
			}
		}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		
		return list;
	}
	
	
}
