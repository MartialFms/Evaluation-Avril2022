package fr.fms.entities;

public class User {
	private int userId;
	private String password;

	public User(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public User(int userId) {
		this.userId = userId;
	}
	
	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + "]";
	}
	
	
}
