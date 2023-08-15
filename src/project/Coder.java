package project;

public class Coder extends User{
	
	
	String skills;
	String assignedProject;
	
	public Coder(String id, String firstName, String lastName, String email, String password, long phoneNum,
			String skills, String assignedProject) {
		super(id, firstName, lastName, email, password, phoneNum);
		this.skills = skills;
		this.assignedProject = assignedProject;
	}



	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getWorkingProject() {
		return assignedProject;
	}



	public void setWorkingProject(String workingProject) {
		this.assignedProject = workingProject;
	}



	@Override
	public String toString() {
		return "Coder [skills=" + skills + ", workingProject=" + assignedProject + ", id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", phoneNum="
				+ phoneNum + "]";
	}


	
	



	
	
}
