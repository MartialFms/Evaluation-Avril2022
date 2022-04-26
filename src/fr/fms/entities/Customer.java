package fr.fms.entities;

public class Customer extends User {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String adress;

	public Customer(int userId, String password, String firstName, String lastName, String email, String phone,
			String adress) {
		super(userId, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Customer [id =" + super.getUserId() + ", password =" + super.getPassword() + ", fistName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", adress=" + adress + "]";
	}

}
