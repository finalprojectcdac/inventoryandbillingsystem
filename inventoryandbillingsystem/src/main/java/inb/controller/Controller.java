package inb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.SupplierRecord;
import inb.service.ServiceInterface;

@RestController
public class Controller
{
	@Autowired
	private ServiceInterface s;
	
	/*
	 * @GetMapping("/abc") public String f1() { return "hello"; }
	 * 
	 * @PutMapping("/addInvoice") public CResult addItem(@RequestBody Invoices
	 * invoice){
	 * 
	 * CResult x= s.addInvoices(invoice); return x; }
	 */
	
	@PutMapping("/saveinventorypage") // created by vaibhav// final done
	public CResult addAllItems(@RequestBody List<Inventory> lsi)
	{
		CResult x = s.addMultipleItems(lsi);
		return x;
	}
	
	@PutMapping("/saveSupplierRecordFromInventorypage")// final done
	public CResult addSupplier(@RequestBody SupplierRecord a){
		
		CResult x=s.RegisterSupplier(a);
		return x;
	}
	
	@GetMapping("/getitemdetailsfrominventorytable")
	public CResult getItemDetails(@RequestParam String item_code) {
		//we have to make the function call here
		CResult x=s.getItem(item_code);
	return x;
	}
	
	@GetMapping("/getsupplierdetailsfromSupplierRecord")
	public CResult getSupplierDetails(@RequestParam String supplier_name) {
		//we have to make the function call here
		CResult x=s.getSupplierDetails(supplier_name);
	return x;
	}
	
	
}
