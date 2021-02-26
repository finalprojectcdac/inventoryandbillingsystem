package inb.models;

public class CResult {
	
	private int status;
	private Inventory content;
	private String reason;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	public Inventory getContent() { return content; } public void setContent(Inventory
	content) { this.content = content; }
	 
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public CResult() {
		// TODO Auto-generated constructor stub
	}
	public CResult(int status, Inventory content, String reason) {

		this.status = status;
		this.content = content;
		this.reason = reason;
	}	
	
	

}
