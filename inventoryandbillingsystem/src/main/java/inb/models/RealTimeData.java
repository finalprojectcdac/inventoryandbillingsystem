package inb.models;

public class RealTimeData {

	private int totalNoOfItems;
	private float totalItemValue;
	
	public RealTimeData() {
	}

	public RealTimeData(int totalNoOfItems, float totalItemValue) {
		super();
		this.totalNoOfItems = totalNoOfItems;
		this.totalItemValue = totalItemValue;
	}

	public int getTotalNoOfItems() {
		return totalNoOfItems;
	}

	public void setTotalNoOfItems(int totalNoOfItems) {
		this.totalNoOfItems = totalNoOfItems;
	}

	public float getTotalItemValue() {
		return totalItemValue;
	}

	public void setTotalItemValue(float totalItemValue) {
		this.totalItemValue = totalItemValue;
	}
	
}
