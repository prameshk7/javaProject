package util;

public class crownStringUtils {
	

    
    
    public static final String USER_NAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String CONFIRM_PASSWORD = "confirmpass";

	// End Parameter names


	public static final String SUCCESS_REGISTER_MESSAGE = "Successful Registration";
	public static final String ERROR_REGISTER_MESSAGE = "Please correct the form data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
	public static final String USERNAME_ERROR_MESSAGE = "Username is not filled.";
	public static final String EMAIL_ERROR_MESSAGE = "Email is not provided.";
	public static final String FIRST_NAME_ERROR_MESSAGE = "First Name not written.";
	public static final String LAST_NAME_ERROR_MESSAGE = "Last Name not written.";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password not matched.";
	public static final String SUCCESS_DELETE_MESSAGE = "Successfully Deleted!";
	public static final String ERROR_DELETE_MESSAGE = "Could not delete the user!";
	public static final String SUCCESS_UPDATE_MESSAGE = "Successfully Updated!";
	public static final String ERROR_UPDATE_MESSAGE = "Could not update user!";
	// End register page messages
	
	// Start login page message
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully LoggedIn!";
	public static final String ERROR_LOGIN_MESSAGE = "Either username or password is not correct!";
	// End login page message
	
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	// End string messages 

//		Insert Querry
		
		public final static String INSET_USER = """
				INSERT INTO user (user_id, username, password, is_admin)
				VALUES (?, ?, ?, ?)
				""";
		public final static String INSERT_PROFILE = """
				INSERT INTO profile (profile_id, full_name, password, user_id, address, contact, profile_pic_url)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		public final static String INSERT_PRODUCT = """
				INSERT INTO product (product_id, product_name, product_desc, product_img_url, stock, product_price, brand)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		public final static String INSERT_ORDER_ITEM = """
				INSERT INTO order_item (order_id, product_id, quantity, total_price, order_date, status, user_id)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		public final static String INSERT_CART = """
				INSERT INTO cart (cart_id, user_id, product_id, quantity) VALUES (?, ?, ?, ?)
				""";
		public final static String INSERT_EXCEPTION = """
				INSERT INTO exception (exceptionId, exception_value, exception_value, exception_time, exception_location, user)
				VALUES (?, ?, ?, ?, ?)
				""";
		
		
//		Get all query
		public final static String GET_ALL_PRODUCT = """
				SELECT * FROM product
				""";
		public final static String GET_PRODUCT_BY_ID = "SELECT * FROM Product WHERE product_id = ?";
		public final static String GET_PRODUCT_SEARCH = "SELECT * FROM Product WHERE product_name LIKE ? OR product_desc LIKE ?";
		public final static String GET_PRODUCT_BY_PRICE = "SELECT * FROM Product WHERE product_price < ?";
		public final static String GET_PRODUCT_STOCK_BY_ID = "SELECT stock FROM Product WHERE product_id = ?";
		public final static String GET_PRODUCT_COUNT = "SELECT COUNT(*) AS product_count FROM Product";

		
		public final static String GET_ALL_ORDER = """
				SELECT * FROM orderItem
				""";	
		public final static String GET_USER_ORDER = "SELECT * FROM orderItem WHERE user_id = ?";
		public final static String UPDATE_ORDER_STATUS = "UPDATE orderItem SET status = ? WHERE order_id = ?";
		
		
		public final static String GET_CART = "SELECT * FROM cart WHERE user_id = ?";
		public final static String GET_CART_QUANTITY = "SELECT * FROM Cart WHERE product_id = ? AND user_id = ?";
		public final static String GET_USER_CART_COUNT = "SELECT COUNT(*) AS cart_count FROM Cart WHERE user_id = ?";
		public final static String GET_CART_ID = "SELECT cart_id FROM Cart WHERE user_id = ? AND product_id = ?";
		public final static String GET_PRODUCT_CART = "SELECT product_id FROM Cart WHERE cart_id = ?";
		

	// Update
	public final static String UPDATE_PRODUCT = "UPDATE Product SET " +
	        "product_name = ?, " +
	        "product_desc = ?, " +
	        "product_img_url = ?, " +
	        "stock = ?, " +
	        "product_price = ?, " +
	        "brand = ? " +
	        "WHERE product_id = ?";
	public final static String UPDATE_PRODUCT_STOCK = "UPDATE Product SET stock = ? WHERE product_id = ?";

	public final static String UPDATE_CART_QUANTITY = "UPDATE Cart SET quantity = ? WHERE cart_id = ?";
		

	//Delete
	public final static String DELETE_PRODUCT = "DELETE FROM Product WHERE product_id = ?";

	public final static String DELETE_CART = "DELETE FROM Cart WHERE cart_id = ?";
	public final static String DELETE_ALL_CART = "DELETE FROM Cart";
		
	



}
