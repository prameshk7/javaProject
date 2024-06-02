package controller.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

public class UserDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/crown_app";
		String username = "root";
		String password = "";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public String addUser( UserModel usermodel) {
		String message = "";
		String query = "INSERT INTO user (userID, userName, firstName, lastName, email, password, confirmpass) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
	        // Establish database connection
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement(query);
	        
	        ps.setString(1, usermodel.getUserId());
	        ps.setString(2, usermodel.getUserName());
	        ps.setString(3, usermodel.getFirstName());
	        ps.setString(4, usermodel.getLastName());
	        ps.setString(5, usermodel.getEmail());
	        ps.setString(6, usermodel.getPassword());
	        ps.setString(7, usermodel.getconfirmpass());
	        int rows = ps.executeUpdate();
		        if ( rows==1){
		        	message = "Successful Registration";
		        }
	        	
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        message = e.getMessage();

	    } 
		return message;
	}
	
	
    public int getUserinfo(String email, String password) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE email = ?");
            st.setString(1, email);


            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String userDb = rs.getString("email");
                String userDbpass = rs.getString("password");

//                // Decrypt password from database and compare
//                String decryptedPassword = PasswordEncryptionWIthAes.decryptPassword(encryptedPassword, "U3CdwubLD5yQbUOG92ZnHw==");

                if (userDbpass!=null && userDb.equals(email) && userDbpass.equals(password)) {
                    return 1; // Login successful
                } else {
                    return 0; // Password mismatch
                }
            } else {
                // No matching record found
                return 0;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
	
    public String getuserName(String email) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT userName FROM user WHERE email = ?");
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString("userName");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
        return null; 
    }
    
    public String getfirstName(String email) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT firstName FROM user WHERE email = ?");
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString("firstName");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
        return null; 
    }

    
    public String getlastName(String email) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT lastName FROM user WHERE email = ?");
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString("lastName");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
        return null; 
    }
    
    
    public void updateUserProfile(String email, String username, String firstName, String lastName) {
        String query = "UPDATE user SET userName = ?, firstName = ?, lastName = ? WHERE email = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User profile updated successfully.");
            } else {
                System.out.println("Failed to update user profile.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getUserIdByEmail(String email) {
    	String userId = "";
    	String query = "SELECT userID FROM user WHERE email = ?";
    	try (Connection con = getConnection();
    			PreparedStatement ps = con.prepareStatement(query)){
    			ps.setString(1, email);
    			
    			ResultSet rs = ps.executeQuery();
    			rs.next();
    			
    			userId = rs.getString(1);
    			}catch (SQLException | ClassNotFoundException e) {
    				e.printStackTrace();
    			}
    	return userId;
    }

    
    
    
    
}




