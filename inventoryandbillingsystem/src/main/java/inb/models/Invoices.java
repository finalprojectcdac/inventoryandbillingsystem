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
	private String email_id;
	private String billing_date;//date added 
	public Invoices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoices(String invoice_no, String mobile_no, String customer_name, float invoice_value, String email_id,
			String billing_date) {
		super();
		this.invoice_no = invoice_no;
		this.mobile_no = mobile_no;
		this.customer_name = customer_name;
		this.invoice_value = invoice_value;
		this.email_id = email_id;
		this.billing_date = billing_date;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getBilling_date() {
		return billing_date;
	}
	public void setBilling_date(String billing_date) {
		this.billing_date = billing_date;
	}
	@Override
	public String toString() {
		return "Invoices [invoice_no=" + invoice_no + ", mobile_no=" + mobile_no + ", customer_name=" + customer_name
				+ ", invoice_value=" + invoice_value + ", email_id=" + email_id + ", billing_date=" + billing_date
				+ "]";
	}
	
	
	
}
