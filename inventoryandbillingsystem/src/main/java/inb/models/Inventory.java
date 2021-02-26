//Created by Vaibhav

package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory
{
	@Id
	private String item_code;
	private String brand, item_name, unit_measurement, stock_entry_date, item_category, supplier_invoice_no;
	private float unit_price, total_value;
	private int quantity;
	
	public Inventory(String item_code, String brand, String item_name, String unit_measurement, String stock_entry_date,
			String item_category, String supplier_invoice_no, float unit_price, float total_value, int quantity) {
		super();
		this.item_code = item_code;
		this.brand = brand;
		this.item_name = item_name;
		this.unit_measurement = unit_measurement;
		this.stock_entry_date = stock_entry_date;
		this.item_category = item_category;
		this.supplier_invoice_no = supplier_invoice_no;
		this.unit_price = unit_price;
		this.total_value = total_value;
		this.quantity = quantity;
	}
	
	public Inventory()
	{
		super();
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
	public String getStock_entry_date() {
		return stock_entry_date;
	}
	public void setStock_entry_date(String stock_entry_date) {
		this.stock_entry_date = stock_entry_date;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public String getSupplier_invoice_no() {
		return supplier_invoice_no;
	}
	public void setSupplier_invoice_no(String supplier_invoice_no) {
		this.supplier_invoice_no = supplier_invoice_no;
	}
	public float getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Inventory [item_code=" + item_code + ", brand=" + brand + ", item_name=" + item_name
				+ ", unit_measurement=" + unit_measurement + ", stock_entry_date=" + stock_entry_date
				+ ", item_category=" + item_category + ", supplier_invoice_no=" + supplier_invoice_no + ", unit_price="
				+ unit_price + ", total_value=" + total_value + ", quantity=" + quantity + "]";
	}
	
}
