package inb.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inb.dao.InventoryRepository;
import inb.dao.InvoiceRepository;
import inb.dao.SupplierRecordRepository;
import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.SupplierRecord;


@Service
public class ServiceImplementation implements ServiceInterface {
	
	@Autowired
	private InventoryRepository ar;
	
	@Autowired
	private SupplierRecordRepository sr;//this is the object for supplier recod repository 
	//this function is for testing


	
	@Autowired
	private InvoiceRepository ir;

	
	/*
	 * public CResult addItem(Inventory item) { CResult c1 =new CResult(0, item,
	 * "failed due to user"); try { ar.save(item); c1.setStatus(1);
	 * c1.setReason("success"); System.out.println(item); } catch (Exception e) {
	 * System.out.println("if if fails we think why"); }
	 * 
	 * return c1; }
	 */
	
	
	//to update the quantity
	public CResult updateQuantity(Inventory item ) {//by Sandipan
		CResult c1 =new CResult(0, item, "failed due to user");
		if(ar.existsById(item.getItem_code()))
		{
			ar.save(item);
			c1.setStatus(1);
			c1.setReason("success");
		}
		return c1;
		
	}
	
	
	//this is registersupplier by maahi
	public CResult RegisterSupplier(SupplierRecord s) {//by sandipan
		CResult c1 =new CResult(0, s, "failed due to user");
		try {
			sr.save(s);
			c1.setStatus(1);
			c1.setReason("success");
			//item.toString();
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("if if fails we think why");
		}
		
		return c1;
	}

	//created by vaibhav
	// addItem 
	public CResult addMultipleItems(List<Inventory> lsi) {
		CResult c1 =new CResult(0, "failed due to user");
		try {
			ar.saveAll(lsi);
			c1.setStatus(1);
			c1.setReason("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c1;
	}
// created by Shubham
@Override
public CResult addInvoices(Invoices invoice) {
	// TODO Auto-generated method stub
	CResult c1 =new CResult(0, invoice, "failed due to user");
	try {
		ir.save(invoice);
		c1.setStatus(1);
		c1.setReason("success");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("if if fails we think why");
	}
	return c1;
 }
}

