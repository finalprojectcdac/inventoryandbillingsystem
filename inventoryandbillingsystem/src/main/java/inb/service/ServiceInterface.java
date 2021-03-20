package inb.service;

import java.util.Date;
import java.util.List;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.SupplierRecord;

public interface ServiceInterface {

	//CResult addItem(Inventory item);this was for testing 
	CResult addMultipleItems(List<Inventory> item);
	CResult RegisterSupplier(SupplierRecord s);
	CResult updateQuantity(Inventory item );
	CResult addInvoices(Invoices invoice);
	CResult getItem(String item_code);//by maahi
	CResult getSupplierDetails(String supplier_name);//by maahi
	CResult getRealTimeData(Date tdate);//For real time data updation.
	void insertIntoItemSale();
	String getSalesInvoiceNofromDB();//for get sales invoice no
	CResult insertListofItemsale(List<ItemSale> list);//for inserting list of item to item_sale table
	CResult getCustomerDetails(String mobile_no);
	CResult insertInvoices(Invoices invoice);
	
	
	
	//maahi
	CResult getItemDetailsForSale(String item_code);
	CResult updateItemQuantity(int quantity, String item_code);
}
