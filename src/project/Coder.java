package project;

public class Coder extends User{
	
	
	String skills;
	

	public Coder(String id, String firstName, String lastName, String email, String password, long phoneNum,
			String skills) {
		super(id, firstName, lastName, email, password, phoneNum);
		this.skills = skills;
	}

	

	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	@Override
	public String toString() {
		return "Coder [skills=" + skills + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
	



	
	
}
