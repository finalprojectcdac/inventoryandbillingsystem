package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoices
{
	@Id
	private String invoice_no;
	private String mobile_no;
	private String customer_name;
	private float invoice_value;
	
	public Invoices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoices(String invoice_no, String mobile_no, String customer_name, float invoice_value) {
		super();
		this.invoice_no = invoice_no;
		this.mobile_no = mobile_no;
		this.customer_name = customer_name;
		this.invoice_value = invoice_value;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public float getInvoice_value() {
		return invoice_value;
	}

	public void setInvoice_value(float invoice_value) {
		this.invoice_value = invoice_value;
	}

	@Override
	public String toString() {
		return "Invoices [invoice_no=" + invoice_no + ", mobile_no=" + mobile_no + ", customer_name=" + customer_name
				+ ", invoice_value=" + invoice_value + "]";
	}
	
	
}
