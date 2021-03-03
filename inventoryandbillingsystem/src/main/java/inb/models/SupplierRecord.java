package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SupplierRecord {

	@Id
	private String supplier_name;
	
	private String supplier_code;
	private String supplier_invoice_number;
	private float supplier_invoice_value;
	
	
	public SupplierRecord(String supplier_code, String supplier_name, String supplier_invoice_number,
			float supplier_invoice_value) {
		super();
		this.supplier_code = supplier_code;
		this.supplier_name = supplier_name;
		this.supplier_invoice_number = supplier_invoice_number;
		this.supplier_invoice_value = supplier_invoice_value;
	}


	public String getSupplier_code() {
		return supplier_code;
	}


	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}


	public String getSupplier_name() {
		return supplier_name;
	}


	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}


	public String getSupplier_invoice_number() {
		return supplier_invoice_number;
	}


	public void setSupplier_invoice_number(String supplier_invoice_number) {
		this.supplier_invoice_number = supplier_invoice_number;
	}


	public float getSupplier_invoice_value() {
		return supplier_invoice_value;
	}


	public void setSupplier_invoice_value(float supplier_invoice_value) {
		this.supplier_invoice_value = supplier_invoice_value;
	}


	public SupplierRecord() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "SupplierRecord [supplier_code=" + supplier_code + ", supplier_name=" + supplier_name
				+ ", supplier_invoice_number=" + supplier_invoice_number + ", supplier_invoice_value="
				+ supplier_invoice_value + "]";
	}


	
	
}
