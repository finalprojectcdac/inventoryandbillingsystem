package inb.service;
import java.util.List;

import inb.models.BillingObject;
import inb.models.CResult;
import inb.models.Employee;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.RetailPriceData;
import inb.models.SupplierRecord;

public interface ServiceInterface {

	//CResult addItem(Inventory item);this was for testing 
	
	
	CResult updateQuantity(Inventory item );
	CResult addInvoices(Invoices invoice);
	CResult getItem(String item_code);//by maahi
	

	CResult getRealTimeData();//For real time data updation.
	void insertIntoItemSale();
	
	
	
	
	
	CResult getCurrentStock();
	
	
	//CResult updateItemQuantity(int quantity, String item_code);
	

	
	
	
	//sagar
	CResult getArrayOfBillingObject();
	
	//monitoring function by maahi
	CResult setSellingPrice(RetailPriceData rpd);
	
	
	CResult updateInventoryAndSellingPriceData(BillingObject bo);
	CResult login(String empId, String password);
	CResult setEmployeeDetails(Employee emp);
	CResult getListOfEmployees();
	
	
	//inventory 
	// getItemDetailsForSale
	CResult getSupplierDetails(String supplier_name);//by maahi
	CResult addMultipleItems(List<Inventory> item);
	CResult RegisterSupplier(SupplierRecord s);
	CResult addNewItemToRetailPriceData(List<RetailPriceData> rpd);// by sagar
	
	//Billing
	String getSalesInvoiceNofromDB();//for get sales invoice no
	CResult getItemDetailsForSale(String item_code);
	CResult getCustomerDetails(String mobile_no);
	CResult insertListofItemsale(List<ItemSale> list);//for inserting list of item to item_sale table
	CResult insertInvoices(Invoices invoice);
	CResult updateItemQuantity(List<Inventory> updateQuantityList);

}
