package Controller;

import Model.User;

public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public static int Login(String username, String password) {
		int userId;
		
		userId = User.Login(username, password);
//		System.out.println(User.Login(username, password));
		if (userId == -1) {
			System.out.println("Wrong username or password");
			return -1;
		}
		
		System.out.println("Welcome " + username);
		return userId;
	}
}
