package Model;

import java.sql.ResultSet;

public class User {

	private Integer userId;
	private String username;
	private String password;
	
	public User(Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User createUser(Integer userId, String username, String password) {
		return new User(userId, username, password);
	}
	
	public static int Login(String username, String password) {
		Connect con = Connect.getConnection();
		
		String query = "SELECT * FROM user WHERE username = '" + username +"' AND password = '"+ password + "'";
		ResultSet rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				// klo ada data return userid nya
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// klo gaada data
		return -1;
	}

}
