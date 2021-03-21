package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//supllier record class ---sagar
@Entity
public class SupplierRecord {

	@Id
	private String supplier_invoice_number;
	private String supplier_name;
	private String supplier_code;
	private float supplier_invoice_value;
	private String purchase_date;
	public SupplierRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierRecord(String supplier_invoice_number, String supplier_name, String supplier_code,
			float supplier_invoice_value, String purchase_date) {
		super();
		this.supplier_invoice_number = supplier_invoice_number;
		this.supplier_name = supplier_name;
		this.supplier_code = supplier_code;
		this.supplier_invoice_value = supplier_invoice_value;
		this.purchase_date = purchase_date;
	}
	public String getSupplier_invoice_number() {
		return supplier_invoice_number;
	}
	public void setSupplier_invoice_number(String supplier_invoice_number) {
		this.supplier_invoice_number = supplier_invoice_number;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public float getSupplier_invoice_value() {
		return supplier_invoice_value;
	}
	public void setSupplier_invoice_value(float supplier_invoice_value) {
		this.supplier_invoice_value = supplier_invoice_value;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	@Override
	public String toString() {
		return "SupplierRecord [supplier_invoice_number=" + supplier_invoice_number + ", supplier_name=" + supplier_name
				+ ", supplier_code=" + supplier_code + ", supplier_invoice_value=" + supplier_invoice_value
				+ ", purchase_date=" + purchase_date + "]";
	}
	
	
}
