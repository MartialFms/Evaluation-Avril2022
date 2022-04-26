package fr.fms.entities;

public class Admin extends User {
	
	private String name;
	private String email;

	public Admin(int userId, String password, String name, String email) {
		super(userId, password);
		this.name = name ;
		this.email = email ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [id =" + super.getUserId() + ", password =" + super.getPassword() + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
