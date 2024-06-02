package model;

public class productModel {
	public String productId;
	public String productName;
	public String productDesc;
	public String productImgUrl;
	public int stock;
	public double productPrice;
	public String brand;
	
	public productModel() {
		
	}
	
	public productModel(String productId, String productName, String productDesc, String productImgUrl, int stock,
			double productPrice, String brand) {
		
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productImgUrl = productImgUrl;
		this.stock = stock;
		this.productPrice = productPrice;
		this.brand = brand;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
