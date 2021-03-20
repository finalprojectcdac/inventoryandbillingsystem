package inb.service;

import java.util.*;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inb.dao.InventoryRepository;

import inb.dao.InvoiceRepository;
import inb.dao.ItemSaleRepository;
import inb.dao.RetailPriceDataRepository;
import inb.dao.SupplierRecordRepository;
import inb.models.BillingObject;
import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.RealTimeData;
import inb.models.RetailPriceData;
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
	
	@Autowired
	private RetailPriceDataRepository rr;
	
	@Autowired
	private ItemSaleRepository isr;
	


	
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
	
	//supplier
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
	// addItem Inventory
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

//addInvoices Invoices
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

//getItem from Inventory
@Override
public CResult getItem(String item_code) {
	// TODO Auto-generated method stub
	CResult c1 =new CResult(0, new Inventory(), "failed due to user");
	Optional<Inventory> i = ar.findById(item_code);
	if(i.isPresent())
	{
		Inventory x = i.get();
		c1.setReason("success");
		c1.setStatus(1);
		c1.setContent(x);
	}
	else
		System.out.println("did not get the object");	
		
	return c1;
}


//get supplier based on name SUPPLIER
//Vaibhav
@Override
public CResult getSupplierDetails(String supplier_name) {
	// TODO Auto-generated method stub
	
//	  List<SupplierRecord> l=new ArrayList<SupplierRecord>();
//	  CResult x=new CResult(0,l,"failed due to user");
//	  l.addAll(sr.f1(supplier_name));
//	  x.setReason("success");
//      x.setStatus(1);
//      x.setSupplierdtls(l);
//     //System.out.println(l);
     
//	CResult c1 =new CResult(0, new SupplierRecord(), "failed due to user");
//	Optional<SupplierRecord> i = sr.findById(supplier_name);
//	if(i.isPresent())
//	{
//		SupplierRecord x = i.get();
//		c1.setReason("success");
//		c1.setStatus(1);
//		c1.setContentsupplier(x);
//	}
//	else
//		System.out.println("did not get the object");	
//	
//	return c1;
	
	CResult c1 = new CResult(0, new SupplierRecord(), "failed due to user");
	SupplierRecord s = sr.f2(supplier_name);
	
	System.out.println(s);
	if(s==null) {
		c1.setReason("Supplier not found");
	}
		else {
			c1.setStatus(1);
			c1.setContentsupplier(s);
			c1.setReason("Supplier found");
		}
	return c1;
}


//real Time data from Inventory
//by Vaibhav
@Override
public CResult getRealTimeData(Date tdate) {
	RealTimeData rtd = new RealTimeData(0,0);
	CResult x = new CResult(0, rtd, "failed due to user");
	List<Inventory> l = new ArrayList<>();
	l = ar.findAll();
	int totalNoOfItems = 0;
	float totalItemValue = 0;
	for(int i = 0; i<l.size(); i++)
	{
		totalNoOfItems += l.get(i).getQuantity();
		totalItemValue += l.get(i).getTotal_value();
	}
	rtd.setTotalNoOfItems(totalNoOfItems);
	rtd.setTotalItemValue(totalItemValue);
	//added some code by sandipan--
	float y=ir.searchByDate(tdate);
	rtd.setTotalValueofInvoices(y);
	int z= rr.f1();
	rtd.setTotalNoOfItemsWithoutSp(z);
	//---------------
	x.setStatus(1);
	x.setRtd(rtd);
	x.setReason("success");
	return x;
}




public void insertIntoItemSale() {//test
	ItemSale as = new ItemSale("8393", "kdfja", 5);
	isr.save(as);
}




//invoice details INVOICES
//by shubham sharma
public String getSalesInvoiceNofromDB() {
	// TODO Auto-generated method stub
	int x=ir.f1();
	
	return String.valueOf(x);
}


//this function will return specific fields like (item_code,brand,item_name,quantity,unit_measurement)
//from BillingObject and selling_price from RetailPriceData
//by maahi
@Override
public CResult getItemDetailsForSale(String item_code) { //by maahi
	// TODO Auto-generated method stub
	Inventory inv = new Inventory();            //postman testing completed
	RetailPriceData rp= new RetailPriceData();
	CResult c1 =new CResult(0, new BillingObject(), "failed due to user");
	BillingObject bo = new BillingObject();
	Optional<Inventory> i = ar.findById(item_code);
	Optional<RetailPriceData> r = rr.findById(item_code);
	
	if(i.isPresent() && r.isPresent()) {
		c1.setReason("item found");
		c1.setStatus(1);
		inv = i.get();
		
		rp = r.get();
		bo.setItem_code(inv.getItem_code());
		bo.setBrand(inv.getBrand());
		bo.setItem_name(inv.getItem_name());
		bo.setUnit_measurement(inv.getUnit_measurement());
		bo.setQuantity(inv.getQuantity());
		bo.setSelling_price(rp.getSelling_price());
		c1.setBo(bo);
		
	}
	
	else if(i.isPresent()) {
		c1.setReason(" only inventory found");
		c1.setStatus(2);
		inv = i.get();
		bo.setItem_code(inv.getItem_code());
		System.out.println(inv.getItem_code());
		bo.setBrand(inv.getBrand());
		bo.setItem_name(inv.getItem_name());
		bo.setUnit_measurement(inv.getUnit_measurement());
		bo.setQuantity(inv.getQuantity());
		bo.setSelling_price(-1);
		c1.setBo(bo);
	}
	
	else if(r.isPresent()) {
		c1.setReason(" only Retail data found");
		c1.setStatus(3);
	}
	
	
		else {
			c1.setStatus(-1);
			c1.setReason(" no item found");
		}
	
	return c1;
	
}



//this function will reduce the mentioned quantity from total quantity
//present in store for the particular item_code
//by maahi
@Override
public CResult updateItemQuantity( int quantity, String item_code) {  //maahi
	// TODO Auto-generated method stub
	CResult c1 =new CResult(0, new Inventory(), "failed due to user"); //postman testing completed
	 ar.f1( quantity,item_code);
	Optional<Inventory> i = ar.findById(item_code);
	if(i.isPresent())
		{
			Inventory x = i.get();
			
			c1.setReason("success");
			c1.setStatus(1);
			//c1.setContent(null);
		}
		else
			System.out.println("did not get the object");
	
	
	return c1;
}



@Override
public CResult insertListofItemsale(List<ItemSale> list) {
	// TODO Auto-generated method stub
	CResult c1 =new CResult(0, "failed due to user");
	try {
		isr.saveAll(list);
		c1.setStatus(1);
		c1.setReason("success");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return c1;

}


public CResult getCustomerDetails(String mobile_no) {
	CResult c1 =new CResult(0,new Invoices() , "failed due to user");
	Invoices invo = ir.searchByMobileNo(mobile_no);
	
	if(invo == null)
	{
		c1.setReason("Supplier not found");
	}
	else {
		System.out.println("heyy");	
	
	c1.setReason("Success");
	c1.setStatus(1);
	c1.setContentinvoice(invo);
	}
	return c1;
 }

// insertInvoice function done by shubham
@Override
public CResult insertInvoices(Invoices invoice) {
	// TODO Auto-generated method stub
	CResult c1 =new CResult(0, new Invoices(), "failed due to user");
	try {
		ir.save(invoice);//changed by sandipan 
		c1.setStatus(1);
		c1.setContentinvoice(invoice);
		c1.setReason("success");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("if if fails we think why");
	}
	return c1;
 }


//
//sagar
@Override
public CResult getArrayOfBillingObject() {
	List<BillingObject> bolist = new ArrayList<>();
	CResult crbo =new CResult(0, "nothig till now", bolist);
	
	//logical issues will seen here
	//finding all the items in INVENTORY
	List<Inventory> invList = new ArrayList<>();
	invList = ar.findAll();
	//finding all the items in INVENTORY
	List<RetailPriceData> rpdList = new ArrayList<>();
	rpdList = rr.findAll();
	//counting lenght of both tables
	int totalNoOfItemsInInventory=invList.size();
	int totalNoOfItemsInReatailPriceData=rpdList.size();
	System.out.println(totalNoOfItemsInInventory+" "+totalNoOfItemsInReatailPriceData);
	if(totalNoOfItemsInInventory==totalNoOfItemsInReatailPriceData) {
	for(int i=0;i<invList.size();i++) {
		
		//setting bolist elements
		BillingObject bo = new BillingObject(invList.get(i).getItem_code(),  invList.get(i).getBrand(),
				invList.get(i).getItem_name(),  invList.get(i).getUnit_measurement(), invList.get(i).getQuantity(),
				0, invList.get(i).getUnit_price());
		//feching selling price from REtail table.
		for(int j=0;j<rpdList.size();j++)
		   {
			
			if(invList.get(i).getItem_code().equalsIgnoreCase(rpdList.get(j).getItem_code()))
			{   
				bo.setSelling_price(rpdList.get(j).getSelling_price());
				//bolist.add(bo);
			}
		   }
		bolist.add(bo); 	
	}
	//now after finding both the list
	crbo.setStatus(1);
	crbo.setReason("sucess");
	crbo.setBillingObjList(bolist);
	}
	else
	crbo.setReason("no of obj miss matched");
	return crbo;
}

@Override
public CResult getCurrentStock() {
	// CResult(status, reason, List<Inventory> inv)
	List <Inventory> invlist = new ArrayList<>();
	CResult crCS =new CResult(invlist, "", 0);
	try {
		invlist=ar.findAll();
		crCS.setInvList(invlist);
		crCS.setReason("success");
		crCS.setStatus(1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return crCS;
}










}