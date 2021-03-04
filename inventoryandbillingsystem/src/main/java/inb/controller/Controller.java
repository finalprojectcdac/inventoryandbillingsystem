package inb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.SupplierRecord;
import inb.service.ServiceInterface;

@RestController
public class Controller
{
	@Autowired
	private ServiceInterface s;
	
	@GetMapping("/abc")
	public String f1()
	{
		return "hello";
	}
	
	@PutMapping("/add")
	public CResult addItem(@RequestBody Inventory item){
		
		CResult x= s.addItem(item);
		return x;
	}
	
	@PutMapping("/addall") // created by vaibhav
	public CResult addAllItems(@RequestBody List<Inventory> lsi)
	{
		CResult x = s.addMultipleItems(lsi);
		return x;
	}
	
	@PutMapping("/saveSupplierRecordFromInventorypage")
	public CResult addSupplier(@RequestBody SupplierRecord a){
		
		CResult x=s.RegisterSupplier(a);
		return x;
	}
	
}
