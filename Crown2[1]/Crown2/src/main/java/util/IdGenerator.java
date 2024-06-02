package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {
	
	public static String getId() {
		String id = "";
		
		SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMddhhmmss");
		id = sdft.format(new Date());		
		
		return id;
	}
	
	public String getOrderId() {
		
		return "Ord" + getId();
	}
	
	public String getProductId() {
		
		return "Prod" + getId();
	}
	
	public String getCartId() {
		
		return "Cart" + getId();
	}
	
	public String getUserId() {
		
		return "User" + getId();
	}
	
}
