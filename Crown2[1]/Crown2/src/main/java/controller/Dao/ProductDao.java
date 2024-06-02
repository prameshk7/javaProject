package controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import Controller.Dao.DatabaseConnection;
import model.productModel;
import util.crownStringUtils;
public class ProductDao {

	private DatabaseConnection db = new DatabaseConnection();
	
	public boolean addProduct(productModel product) {
		boolean flag = false;
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.INSERT_PRODUCT);
			st.setString(1, product.getProductId());
			st.setString(2, product.getProductName());
			st.setString(3, product.getProductDesc());
			st.setString(4, product.getProductImgUrl());
			st.setInt(5, product.getStock());
			st.setDouble(6, product.getProductPrice());
			st.setString(7, product.getBrand());
			
			flag = st.execute();
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<productModel> getAllProducts() {
		
		List<productModel> list = new ArrayList<productModel>();
		try {
			Connection con = db.getConnection();
			Statement st = con.createStatement();
		
			
			ResultSet table = st.executeQuery(crownStringUtils.GET_ALL_PRODUCT);
			while(table.next()) {
				String productId = table.getString("product_id");
				String productName = table.getString("product_name");
				String productDesc = table.getString("product_desc");
				String productImageUrl = table.getString("product_img_url");
				int stock = table.getInt("stock");
				double productPrice = table.getDouble("product_price");
				String brand = table.getString("brand");
				
				productModel product = new productModel(productId, productName, productDesc, productImageUrl, stock, productPrice, brand);
				list.add(product);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public productModel getProductByProductId(String prodId) {
		productModel product = new productModel();
		String proId = prodId.trim();
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_BY_ID);
			st.setString(1, proId);
			
			ResultSet table = st.executeQuery();
			if(table.next()) {
				
				product.setProductId(prodId.trim());
				product.setProductName(table.getString("product_name"));
				product.setProductDesc(table.getString("product_desc"));
				product.setProductImgUrl(table.getString("product_img_url"));
				product.setStock(table.getInt("stock"));
				product.setProductPrice(table.getDouble("product_price"));
				product.setBrand(table.getString("brand"));
			}else {
				System.out.print("Hello");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public List<productModel> getProductBySearch(String prompt){
		List<productModel> list = new ArrayList<productModel>();
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_SEARCH);
			st.setString(1, prompt);
			st.setString(2, prompt);
			
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String productId = table.getString("product_id");
				String productName = table.getString("product_name");
				String productDesc = table.getString("product_desc");
				String productImageUrl = table.getString("product_img_url");
				int stock = table.getInt("stock");
				double productPrice = table.getDouble("product_price");
				String brand = table.getString("brand");
				
				productModel product = new productModel(productId, productName, productDesc, productImageUrl, stock, productPrice, brand);
				list.add(product);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<productModel> getProductByPrice(double price){
		List<productModel> list = new ArrayList<productModel>();
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_BY_PRICE);
			st.setDouble(1, price);

			
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String productId = table.getString("product_id");
				String productName = table.getString("product_name");
				String productDesc = table.getString("product_desc");
				String productImageUrl = table.getString("product_img_url");
				int stock = table.getInt("stock");
				double productPrice = table.getDouble("product_price");
				String brand = table.getString("brand");
				
				productModel product = new productModel(productId, productName, productDesc, productImageUrl, stock, productPrice, brand);
				list.add(product);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public void updateProduct(productModel product) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.UPDATE_PRODUCT);
			st.setString(1, product.getProductName());
			st.setString(2, product.getProductDesc());
			st.setString(3, product.getProductImgUrl());
			st.setInt(4, product.getStock());
			st.setDouble(5, product.getProductPrice());
			st.setString(6, product.getBrand());
			st.setString(7, product.getProductId());
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
		
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStock(String proId, int stock) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.UPDATE_PRODUCT_STOCK);
			st.setInt(1, stock);
			st.setString(2, proId);
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(String proId) {
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.DELETE_PRODUCT);
			st.setString(1, proId);
			
			int row = st.executeUpdate();
			
			if (row >= 1) {
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getProductStockById(String proId) {
		int stock = 0;
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_STOCK_BY_ID);
			st.setString(1, proId);
			
			ResultSet table = st.executeQuery();
			table.next();
			stock = table.getInt(1);
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
	
	public int productCount() {
		int count = 0;
		
		try {
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement(crownStringUtils.GET_PRODUCT_COUNT);
			
			ResultSet table = st.executeQuery();
			table.next();
			count = table.getInt(1);
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
}
