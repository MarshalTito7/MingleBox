package project;

public class Buyer extends User {
	
	static final private String cat = "Buyer";
	
	public Buyer(String id, String firstName, String lastName, String email, String password, long phoneNum) {
		super(id, firstName, lastName, email, password, phoneNum);
		// TODO Auto-generated constructor stub
	}
	
	public static String getCat() {
		return cat;
	}

	
	@Override
	public String toString() {
		return "Buyer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
	
	

	
}
