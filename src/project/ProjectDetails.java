package project;

public class ProjectDetails {
	String projName;
	String reqSkill;
	String assignCoder;
	String ownerId;
	String projDescription;
	String status;
	int paymentToBeMade;




	public ProjectDetails(String projName, String reqSkill, String assignCoder, String ownerId, String projDescription,
			String status, int paymentToBeMade) {
		super();
		this.projName = projName;
		this.reqSkill = reqSkill;
		this.assignCoder = assignCoder;
		this.ownerId = ownerId;
		this.projDescription = projDescription;
		this.status = status;
		this.paymentToBeMade = paymentToBeMade;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getReqSkill() {
		return reqSkill;
	}

	public void setReqSkill(String reqSkill) {
		this.reqSkill = reqSkill;
	}


	public String getAssignCoder() {
		return assignCoder;
	}

	public void setAssignCoder(String assignCoder) {
		this.assignCoder = assignCoder;
	}

	public String getProjDescription() {
		return projDescription;
	}

	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	
	public int getPaymentToBeMade() {
		return paymentToBeMade;
	}

	public void setPaymentToBeMade(int paymentToBeMade) {
		this.paymentToBeMade = paymentToBeMade;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projName=" + projName + ", reqSkill=" + reqSkill + ", assignCoder=" + assignCoder
				+ ", ownerId=" + ownerId + ", projDescription=" + projDescription + ", status=" + status
				+ ", paymentToBeMade=" + paymentToBeMade + "]";
	}

	
	
	

	

	

	
	
	
	
	
	
}
