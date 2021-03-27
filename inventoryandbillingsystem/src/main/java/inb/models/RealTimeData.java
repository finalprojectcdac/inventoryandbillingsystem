package inb.models;

public class RealTimeData {

	private int totalNoOfItems;
	private float totalItemValue;
	private String totalValueofInvoices;//added this variable
	private int   totalNoOfItemsWithoutSp;//added this variable
	
	public RealTimeData() {
		super();
	}
	
	public RealTimeData(int totalNoOfItems, float totalItemValue, String totalValueofInvoices,
			int totalNoOfItemsWithoutSp) {
		super();
		this.totalNoOfItems = totalNoOfItems;
		this.totalItemValue = totalItemValue;
		this.totalValueofInvoices = totalValueofInvoices;
		this.totalNoOfItemsWithoutSp = totalNoOfItemsWithoutSp;
	}
	
	
	public String getTotalValueofInvoices() {
		return totalValueofInvoices;
	}

	public void setTotalValueofInvoices(String totalSales) {
		this.totalValueofInvoices = totalSales;
	}

	public int getTotalNoOfItemsWithoutSp() {
		return totalNoOfItemsWithoutSp;
	}

	public void setTotalNoOfItemsWithoutSp(int totalNoOfItemsWithoutSp) {
		this.totalNoOfItemsWithoutSp = totalNoOfItemsWithoutSp;
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
