package project;

public class Bids {
	String coderId, projId;
	int bidAmt;
	
	
	public Bids(String coderId, String projId, int bidAmt) {
		super();
		this.coderId = coderId;
		this.projId = projId;
		this.bidAmt = bidAmt;
	}
	
	public String getCoderId() {
		return coderId;
	}
	public void setCoderId(String coderId) {
		this.coderId = coderId;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public int getBidAmt() {
		return bidAmt;
	}
	public void setBidAmt(int bidAmt) {
		this.bidAmt = bidAmt;
	}

	@Override
	public String toString() {
		return "Bids [coderId=" + coderId + ", projId=" + projId + ", bidAmt=" + bidAmt + "]";
	}
	
	
	
	
}