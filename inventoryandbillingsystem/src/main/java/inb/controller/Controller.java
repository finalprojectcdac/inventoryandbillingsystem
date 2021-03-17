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

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
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
		 s.insertIntoItemSale();
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
	
	@GetMapping("/getRealTimeData")
	public CResult getRealTimeData() {
		CResult x = s.getRealTimeData();
		return x;
	}
	
	@GetMapping("/getInvoicesdetailsfromInvoices") //postman testing by shubham sharma
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
}