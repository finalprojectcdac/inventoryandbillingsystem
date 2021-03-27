package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailPriceData {
	
	@Id
	private String item_code;
	private float selling_price;
	
	public RetailPriceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RetailPriceData(String item_code, float selling_price) {
		super();
		this.item_code = item_code;
		this.selling_price = selling_price;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public float getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(float selling_price) {
		this.selling_price = selling_price;
	}

	@Override
	public String toString() {
		return "RetailPriceData [item_code=" + item_code + ", selling_price=" + selling_price + "]";
	}
	
	

}
