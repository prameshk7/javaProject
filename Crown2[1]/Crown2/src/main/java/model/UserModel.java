
package model;


public class UserModel {
	
	private String userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmpass;
	
    // Constructor with parameters
    public UserModel(String userId, String userName, String firstName, String lastName, String email, String password, String confirmpass) {
        super();
        
        this.userId = userId;
    	this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmpass = confirmpass;
    }
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getConfirmpass() {
		return confirmpass;
	}


	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getconfirmpass() {
		return confirmpass;
	}
	public void setconfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}
	


	
	
}
