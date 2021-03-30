package inb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inb.models.BillingObject;
import inb.models.CResult;
import inb.models.Employee;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.RetailPriceData;
import inb.models.SupplierRecord;
import inb.models.UResult;
import inb.models.User;
import inb.service.ServiceInterface;

@CrossOrigin//(origins = "https://ibs-dev-app.herokuapp.com")
@RestController
public class Controller {
	@Autowired
	private ServiceInterface s;

	@PutMapping("/test")
	public void test() {
		System.out.println("heloooo");
		// s.insertIntoItemSale();
	}

	@GetMapping("/abc")
	public ArrayList<User> f1() {
		ArrayList<User> u = new ArrayList<User>();
		User x = new User("sandipan", "56445866", "kolkata");
		User y = new User("ram", "56445866", "kolkata");
		User z = new User("sam", "56445866", "kolkata");
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

	@GetMapping("/getitemdetailsfrominventorytable")
	public CResult getItemDetails(@RequestParam String item_code) {
		// we have to make the function call here
		System.out.println(item_code);
		CResult x = s.getItem(item_code);
		return x;
	}

	///
	@GetMapping("/getinvoicesdetailsfromInvoices")
	public CResult getInvoicesDetails(@RequestParam String mobile_no) {
		// we have to make the function call here
		System.out.println(mobile_no);
		CResult x = s.getCustomerDetails(mobile_no);
		return x;
	}

	// ==================================================================================

//==========================================================billing===================

	// controller function to update item quantity
//	@PostMapping("/updateitemquantity") //maahi
//	public CResult updateItemQuantity(@RequestParam int quantity, String item_code) {
//		CResult c = s.updateItemQuantity(quantity,item_code);
//		return c;
//	}

//================================================================================================

	@GetMapping("/getArrayOfBillingObject") // sagar
	public CResult getBillingObjDetails() {
		System.out.println("we are trying to get billing obj list");
		CResult cres = s.getArrayOfBillingObject();
		return cres;

	}

	@GetMapping("/getCurrentStock") // SHUBHAM
	public CResult getCurrentStock() {
		System.out.println("we are trying to get billing obj list");
		CResult cres = s.getCurrentStock();
		return cres;
	}

//controller function to insert retailpricedata object by maahi
	@PutMapping("/setSellingPrice") // postman testing done
	public CResult insertRetailPriceData(@RequestBody RetailPriceData rpd) { // maahi

		System.out.println("retail price inserted");
		CResult c = s.setSellingPrice(rpd);
		return c;
	}

	// controller function for updating all the details of inventory including the
	// selling price in the retail_price_data
	@PutMapping("updateInventoryAndSellingPrice")
	public CResult updateInventoryAndSellingPriceData(@RequestBody BillingObject bo) {
		// using billing object for updating as it has all the fields which are supposed
		// to be updated.
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
		System.out.println(startDate);
		CResult c1 = s.getSalesReport(startDate, endDate);
		return c1;
	}

//==============================REAL TIME DATA FUNCTIONS==========================================

	@GetMapping("/getRealTimeData")
	public CResult getRealTimeData() {
		CResult x = s.getRealTimeData();
		return x;
	}

//==============================INVENTORY FUNCTIONS==========================================
	// =====================fetching functions===========================
	// "/getitemdetailsforsale" :-already in billing functions
	@GetMapping("/getsupplierdetailsfromSupplierRecord")
	public CResult getSupplierDetails(@RequestParam String supplier_name) {
		// we have to make the function call here
		System.out.println(supplier_name);
		CResult x = s.getSupplierDetails(supplier_name);
		return x;
	}

	// =====================Inserting/Updating functions===========================
	// created by vaibhav
	@PutMapping("/saveinventorypage")
	public CResult addAllItems(@RequestBody ArrayList<Inventory> lsi) {
		System.out.println("save inventory called");
		CResult x = s.addMultipleItems(lsi);
		return x;
	}

	@PutMapping("/saveSupplierRecordFromInventorypage") // final done
	public CResult addSupplier(@RequestBody SupplierRecord a) {
		System.out.println("save supplier called");
		CResult x = s.RegisterSupplier(a);
		return x;
	}

	@PutMapping("/addItemsToRetailPriceData")
	public CResult addItemsToRetailPriceData(@RequestBody List<RetailPriceData> rpdList) {
		System.out.println("working");
		CResult c = s.addNewItemToRetailPriceData(rpdList);
		return c;
	}
//==============================BILLING FUNCTIONS==========================================
	// =====================fetching functions===========================

// by Sandipan
//the function returns the current bill no to be generated 	
	@GetMapping("/getSalesInvoicenumber")
	public String getSaleInvoiceNo() {
		// s.insertIntoItemSale();
		String x = s.getSalesInvoiceNofromDB();
		return x;

	}

//controller function for getting item details for sale	
//by Maahi
	@GetMapping("/getitemdetailsforsale")
	public CResult getItemDetailsForSale(@RequestParam String item_code) {
		System.out.println(item_code);
		CResult c = s.getItemDetailsForSale(item_code);
		System.out.println(c);
		return c;
	}

	@GetMapping("/getCustomerdetailsfromInvoices") // postman testing by shubham sharma
	public CResult getCustomerDetails(@RequestParam String mobile_no) {
		// we have to make the function call here
		System.out.println(mobile_no);
		CResult x = s.getCustomerDetails(mobile_no);
		return x;
	}

//=====================Inserting/Updating functions===========================
	// by Sandipan
	// this function
	@PutMapping("/ListItemsinserttoItemSale")
	public CResult insertListOfItems(@RequestBody List<ItemSale> list) {

		CResult y = s.insertListofItemsale(list);
		return y;
	}

	// By Shubham
	@PutMapping("/insertInvoicefromInvoices")
	public CResult insertInvoices(@RequestBody Invoices invoice) {
		CResult x = s.insertInvoices(invoice);
		return x;
	}

	// By Maahi
	@PutMapping("/updateitemquantity")
	public CResult updateItemQuantity(@RequestBody List<Inventory> updateQuantityList) {
		CResult c = s.updateItemQuantity(updateQuantityList);
		return c;
	}
//===================================USERS=========================

	@PutMapping("/registerEmployee")
	public UResult registerEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		UResult ur = s.registerEmployee(emp);
		return ur;
	}

	@GetMapping("/login")
	public UResult login(@RequestParam String empId, @RequestParam String password) {
		System.out.println(empId);
		System.out.println(password);
		UResult ur = s.login(empId, password);
		return ur;
	}

	@GetMapping("/getListOfEmployees")
	public UResult getListOfEmployees() {
		UResult ur = s.getListOfEmployees();
		return ur;
	}

	@PutMapping("/updateEmployeeDetails")
	public UResult updateEmployeeDetails(@RequestBody Employee emp) {
		UResult ur = s.updateEmployeeDetails(emp);
		return ur;
	}

	@GetMapping("/getEmployeeDetails")
	public UResult getEmployeeDetails(@RequestParam String empId) {
		System.out.println(empId);
		UResult ur = s.getEmployeeDetails(empId);
		return ur;
	}

}
