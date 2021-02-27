package inb.models;

public class ItemSale {

	private String invoice_no;
	private String item_code;
	private int quantity_sold;
	public ItemSale(String invoice_no, String item_code, int quantity_sold) {
		super();
		this.invoice_no = invoice_no;
		this.item_code = item_code;
		this.quantity_sold = quantity_sold;
	}
	public ItemSale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public int getQuantity_sold() {
		return quantity_sold;
	}
	public void setQuantity_sold(int quantity_sold) {
		this.quantity_sold = quantity_sold;
	}
	@Override
	public String toString() {
		return "ItemSale [invoice_no=" + invoice_no + ", item_code=" + item_code + ", quantity_sold=" + quantity_sold
				+ "]";
	}
	
	
}
