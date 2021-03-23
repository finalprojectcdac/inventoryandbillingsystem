package inb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inb.models.BillingObject;
import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.RetailPriceData;
import inb.models.SupplierRecord;
import inb.models.User;
import inb.service.ServiceInterface;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class Controller
{
	@Autowired
	private ServiceInterface s;
	
	 @PutMapping("/test")
	 public void test() {
		 System.out.println("heloooo");
		// s.insertIntoItemSale();
	 }
	 @GetMapping("/abc") public ArrayList<User> f1() { 
		 ArrayList<User> u= new ArrayList<User>();
		 User x= new User("sandipan","56445866","kolkata");
		 User y= new User("ram","56445866","kolkata");
		 User z= new User("sam","56445866","kolkata");
		 u.add(x);
		 u.add(y);
		 u.add(z);
		 return u; 
		 
	 }
	
	/*
	 * @GetMapping("/abc") public String f1() { return "hello"; }
	 * 
	 * @PutMapping("/addInvoice") public CResult addItem(@RequestBody Invoices
	 * invoice){
	 * 
	 * CResult x= s.addInvoices(invoice); return x; }
	 */
	
	@PutMapping("/saveinventorypage") // created by vaibhav// final done
	public CResult addAllItems(@RequestBody ArrayList<Inventory> lsi)
	{
		System.out.println("save inventory called");
		CResult x = s.addMultipleItems(lsi);
		return x;
	}
	
	@PutMapping("/saveSupplierRecordFromInventorypage")// final done
	public CResult addSupplier(@RequestBody SupplierRecord a){
		System.out.println("save supplier called");
		CResult x=s.RegisterSupplier(a);
		return x;
	}
	
	@GetMapping("/getitemdetailsfrominventorytable")
	public CResult getItemDetails(@RequestParam String item_code) {
		//we have to make the function call here
		System.out.println(item_code);
		CResult x=s.getItem(item_code);
	return x;
	}
	
	@GetMapping("/getsupplierdetailsfromSupplierRecord")
	public CResult getSupplierDetails(@RequestParam String supplier_name) {
		//we have to make the function call here
		System.out.println(supplier_name);
		CResult x=s.getSupplierDetails(supplier_name);
	return x;
	}
	  ///
	@GetMapping("/getinvoicesdetailsfromInvoices")
	public CResult getInvoicesDetails(@RequestParam String mobile_no) {
		//we have to make the function call here
		System.out.println(mobile_no);
		CResult x=s.getCustomerDetails(mobile_no);
	return x;
	}
	
	@GetMapping("/getRealTimeData")
	public CResult getRealTimeData() {
		CResult x = s.getRealTimeData();
		return x;
	}
	
	
	
	// ==================================================================================
	
	
	
	
	
	//controller function for the billing 
	@GetMapping("/getSalesInvoicenumber")//done post man testing by sandipan
	public String getSaleInvoiceNo() {
		//s.insertIntoItemSale();
		String x=s.getSalesInvoiceNofromDB();
		return x;
		
	}
	

	@PutMapping("/ListItemsinserttoItemSale")//done post man testing by sandipan
	public CResult insertListOfItems(@RequestBody List<ItemSale> list) {
		
		CResult y=s.insertListofItemsale(list);
		return y;
		
	}
	
	@GetMapping("/getCustomerdetailsfromInvoices") //postman testing by shubham sharma
	public CResult getCustomerDetails(@RequestParam String mobile_no) {
		//we have to make the function call here
		System.out.println(mobile_no);
		CResult x=s.getCustomerDetails(mobile_no);
	return x;
	}
	


@PutMapping("/insertInvoicefromInvoices") //postman testing done by shubham
public CResult insertInvoices(@RequestBody Invoices invoice)
{
	CResult x = s.insertInvoices(invoice);
	return x;
}
//==========================================================billing===================


    //controller function for getting item details for sale	
	@GetMapping("/getitemdetailsforsale") //maahi
	public CResult getItemDetailsForSale(@RequestParam String item_code) {
		System.out.println(item_code);
		CResult c=s.getItemDetailsForSale(item_code);
		System.out.println(c);
		return c;
	}
	
	//controller function to update item quantity
//	@PostMapping("/updateitemquantity") //maahi
//	public CResult updateItemQuantity(@RequestParam int quantity, String item_code) {
//		CResult c = s.updateItemQuantity(quantity,item_code);
//		return c;
//	}
	@PutMapping("/updateitemquantity") //maahi
	public CResult updateItemQuantity(@RequestBody List <Inventory> updateQuantityList) {
		CResult c = s.updateItemQuantity(updateQuantityList);
		return c;
	}
//================================================================================================

@GetMapping("/getArrayOfBillingObject") //sagar
public CResult getBillingObjDetails() {
	System.out.println("we are trying to get billing obj list");
	CResult cres=s.getArrayOfBillingObject();
	return cres;
	
}
	
@GetMapping("/getCurrentStock") //SHUBHAM
public CResult getCurrentStock() {
	System.out.println("we are trying to get billing obj list");
	CResult cres=s.getCurrentStock();
	return cres;
}

//controller function to insert retailpricedata object by maahi
	@PutMapping("/setSellingPrice")                //postman testing done
	public CResult insertRetailPriceData(@RequestBody RetailPriceData rpd) { //maahi
		
		System.out.println("retail price inserted");
		CResult c = s.setSellingPrice(rpd);
		return c;
	}
	
//controller funtion for getting list of RetailPriceData objects by sagar
	@PutMapping("/addItemsToRetailPriceData")
	public CResult addItemsToRetailPriceData(@RequestBody List<RetailPriceData> rpdList) {
		System.out.println("working");
		CResult c = s.addNewItemToRetailPriceData(rpdList);  //postman testing done by sagar
		return c;
	}
	
	//controller function for updating all the details of inventory including the selling price in the retail_price_data
	@PutMapping("updateInventoryAndSellingPrice")
	public CResult updateInventoryAndSellingPriceData(@RequestBody BillingObject bo) {
	//using billing object for updating as it has all the fields which are supposed to be updated.
	System.out.println(bo);
	CResult c = s.updateInventoryAndSellingPriceData(bo);
	return c;
	}
	
	@GetMapping("getPurchaseReport")
	public CResult getPruchaseReport(@RequestParam String startDate, @RequestParam String endDate) {
		CResult c1 = s.getPurchaseReport(startDate, endDate);
		return c1;
	}

	@GetMapping("getSalesReport")
	public CResult getSalesReport(@RequestParam String startDate, @RequestParam String endDate) {
		CResult c1 = s.getSalesReport(startDate, endDate);
		return c1;
	}

}