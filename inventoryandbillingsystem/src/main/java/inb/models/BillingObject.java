package inb.models;

public class BillingObject {
	
	private String item_code, brand, item_name, unit_measurement;
	private int quantity;
	private float selling_price;
	private float unit_price;//sagar
	
	
	//sagar
	public float getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	
	public BillingObject(String item_code, String brand, String item_name, String unit_measurement, int quantity,
			float selling_price, float unit_price) {
		super();
		this.item_code = item_code;
		this.brand = brand;
		this.item_name = item_name;
		this.unit_measurement = unit_measurement;
		this.quantity = quantity;
		this.selling_price = selling_price;
		this.unit_price = unit_price;
	}
	//$
	public BillingObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillingObject(String item_code, String brand, String item_name, String unit_measurement, int quantity,
			float selling_price) {
		super();
		this.item_code = item_code;
		this.brand = brand;
		this.item_name = item_name;
		this.unit_measurement = unit_measurement;
		this.quantity = quantity;
		this.selling_price = selling_price;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getUnit_measurement() {
		return unit_measurement;
	}
	public void setUnit_measurement(String unit_measurement) {
		this.unit_measurement = unit_measurement;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(float selling_price) {
		this.selling_price = selling_price;
	}
	@Override
	public String toString() {
		return "BillingObject [item_code=" + item_code + ", brand=" + brand + ", item_name=" + item_name
				+ ", unit_measurement=" + unit_measurement + ", quantity=" + quantity + ", selling_price="
				+ selling_price + "]";
	}
	
	

}
