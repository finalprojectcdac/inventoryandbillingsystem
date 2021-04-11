package inb.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inb.dao.EmployeeRepository;
import inb.dao.InventoryRepository;

import inb.dao.InvoiceRepository;
import inb.dao.ItemSaleRepository;
import inb.dao.RetailPriceDataRepository;
import inb.dao.SupplierRecordRepository;
import inb.models.BillingObject;
import inb.models.CResult;
import inb.models.Employee;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.ItemSale;
import inb.models.RealTimeData;
import inb.models.RetailPriceData;
import inb.models.SupplierRecord;
import inb.models.UResult;

@Service
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	private InventoryRepository ar;

	@Autowired
	private SupplierRecordRepository sr;

	@Autowired
	private InvoiceRepository ir;

	@Autowired
	private RetailPriceDataRepository rr;

	@Autowired
	private ItemSaleRepository isr;

	@Autowired
	private EmployeeRepository er;

//addInvoices Invoices
// created by Shubham
	@Override
	public CResult addInvoices(Invoices invoice) {
		// TODO Auto-generated method stub
		CResult c1 = new CResult(0, invoice, "failed due to user");
		try {
			ir.save(invoice);
			c1.setStatus(1);
			c1.setReason("success");
		} catch (Exception e) {
		}
		return c1;
	}

//getItem from Inventory
	@Override
	public CResult getItem(String item_code) {
		// TODO Auto-generated method stub
		CResult c1 = new CResult(0, new Inventory(), "failed due to user");
		try {
			Optional<Inventory> i = ar.findById(item_code);
			if (i.isPresent()) {
				Inventory x = i.get();
				c1.setReason("success");
				c1.setStatus(1);
				c1.setContent(x);
			} else
				System.out.println("did not get the object");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c1;
	}

//real Time data from Inventory
//by Vaibhav
	@Override
	public CResult getRealTimeData() {
		RealTimeData rtd = new RealTimeData();
		CResult x = new CResult(0, rtd, "failed due to user");
		List<Inventory> l = new ArrayList<>();
		try {
			String totalSales = ir.todaysSale();
			int noOfItemsWithoutSp = rr.f1();
			l = ar.findAll();
			int totalNoOfItems = 0;
			float totalItemValue = 0;
			for (int i = 0; i < l.size(); i++) {
				totalNoOfItems += l.get(i).getQuantity();
				totalItemValue += l.get(i).getTotal_value();
			}
			rtd.setTotalNoOfItems(totalNoOfItems);
			rtd.setTotalItemValue(totalItemValue);
			rtd.setTotalValueofInvoices(totalSales);
			rtd.setTotalNoOfItemsWithoutSp(noOfItemsWithoutSp);
			x.setStatus(1);
			x.setRtd(rtd);
			x.setReason("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

//=======================================BILLING FUNCTION============
//invoice details INVOICES

//sagar
	@Override
	public CResult getArrayOfBillingObject() {
		List<BillingObject> bolist = new ArrayList<>();
		CResult crbo = new CResult(0, "nothig till now", bolist);

		// logical issues will seen here
		// finding all the items in INVENTORY
		List<Inventory> invList = new ArrayList<>();
		try {
			invList = ar.findAll();
			// finding all the items in INVENTORY
			List<RetailPriceData> rpdList = new ArrayList<>();
			rpdList = rr.findAll();
			// counting length of both tables
			int totalNoOfItemsInInventory = invList.size();
			int totalNoOfItemsInReatailPriceData = rpdList.size();
			System.out.println(totalNoOfItemsInInventory + " " + totalNoOfItemsInReatailPriceData);
			if (totalNoOfItemsInInventory == totalNoOfItemsInReatailPriceData) {
				for (int i = 0; i < invList.size(); i++) {

					// setting bolist elements
					BillingObject bo = new BillingObject(invList.get(i).getItem_code(), invList.get(i).getBrand(),
							invList.get(i).getItem_name(), invList.get(i).getUnit_measurement(),
							invList.get(i).getQuantity(), 0, invList.get(i).getUnit_price());
					// fetching selling price from REtail table.
					for (int j = 0; j < rpdList.size(); j++) {

						if (invList.get(i).getItem_code().equalsIgnoreCase(rpdList.get(j).getItem_code())) {
							bo.setSelling_price(rpdList.get(j).getSelling_price());
							// bolist.add(bo);
						}
					}
					bolist.add(bo);
				}
				// now after finding both the list
				crbo.setStatus(1);
				crbo.setReason("sucess");
				crbo.setBillingObjList(bolist);
			} else
				crbo.setReason("no of obj miss matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crbo;
	}

	@Override
	public CResult getCurrentStock() {
		List<Inventory> invlist = new ArrayList<>();
		CResult crCS = new CResult(invlist, "", 0);
		try {
			invlist = ar.findAll();
			crCS.setInvList(invlist);
			crCS.setReason("success");
			crCS.setStatus(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crCS;
	}

//function to add/insert retailpricedata object          by maahi
	@Override
	public CResult setSellingPrice(RetailPriceData rpd) { // postman testing completed by maahi
		// TODO Auto-generated method stub
		CResult c = new CResult(0, new RetailPriceData(), "failed due to user");
		try {
			rr.save(rpd);
			c.setStatus(1);
			c.setReason("success");
			c.setContentRpd(rpd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public CResult updateInventoryAndSellingPriceData(BillingObject bo) {
		CResult c1 = new CResult(0, "Failed");
		try {
			Optional<Inventory> i = ar.findById(bo.getItem_code());
			if (i.get().getItem_code() == bo.getItem_code()) {
				Inventory inv = i.get();
				inv.setItem_code(bo.getItem_code());
				inv.setBrand(bo.getBrand());
				inv.setItem_category(bo.getItem_category());
				inv.setItem_name(bo.getItem_name());
				inv.setQuantity(bo.getQuantity());
				inv.setUnit_price(bo.getUnit_price());
				inv.setUnit_measurement(bo.getUnit_measurement());
				inv.setTotal_value(inv.getUnit_price() * inv.getQuantity());
				ar.save(inv);
				RetailPriceData rpd = new RetailPriceData(bo.getItem_code(), bo.getSelling_price());
				rr.save(rpd);
				c1.setStatus(1);
				c1.setReason("Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c1;
	}
//==========================================INVENTORY FUNCTIONS==================

//get supplier based on name SUPPLIER
//Vaibhav
	@Override
	public CResult getSupplierDetails(String supplier_name) {

		CResult c1 = new CResult(0, new SupplierRecord(), "failed due to user");
		try {
			SupplierRecord s = sr.f2(supplier_name);

			System.out.println(s);
			if (s == null) {
				c1.setReason("Supplier not found");
			} else {
				c1.setStatus(1);
				c1.setContentsupplier(s);
				c1.setReason("Supplier found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

//created by vaibhav
	// addItem Inventory
	public CResult addMultipleItems(List<Inventory> lsi) {
		CResult c1 = new CResult(0, "failed due to user");
		System.out.println(lsi);
		try {
			ar.saveAll(lsi);
			c1.setStatus(1);
			c1.setReason("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

	// supplier
	// this is registersupplier by maahi
	public CResult RegisterSupplier(SupplierRecord s) {// by sandipan
		CResult c1 = new CResult(0, s, "failed due to user");
		try {
			sr.save(s);
			c1.setStatus(1);
			c1.setReason("success");
			// item.toString();
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c1;
	}

	// function to add list of RetailPriceData objects by sagar
	@Override
	public CResult addNewItemToRetailPriceData(List<RetailPriceData> rpd) { // by sagar
		// TODO Auto-generated method stub

		// new task:: to check my list conatain 1 : if yes then dont updtae
		// if conatin -1 then set -1
		// do it using .save
		CResult c = new CResult(0, "nothing done");
		try {
			for (int i = 0; i < rpd.size(); i++) {
				float selling_price = rpd.get(i).getSelling_price();
				if (selling_price == -1) {
					rr.save(rpd.get(i));
					c.setStatus(1);
					c.setReason("sucess");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
//==========================================BILLING FUNCTIONS==================

//by shubham sharma
	public String getSalesInvoiceNofromDB() {
		int x = -1;
		try {
			x = ir.f1();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(x);
	}

//by Maahi
	@Override
	public CResult getItemDetailsForSale(String item_code) { // by maahi
		// TODO Auto-generated method stub
		Inventory inv = new Inventory(); // postman testing completed
		RetailPriceData rp = new RetailPriceData();
		CResult c1 = new CResult(0, new BillingObject(), "failed due to user");
		BillingObject bo = new BillingObject();
		try {
			Optional<Inventory> i = ar.findById(item_code);
			Optional<RetailPriceData> r = rr.findById(item_code);

			if (i.isPresent() && r.isPresent()) {
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

			else if (i.isPresent()) {
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

			else if (r.isPresent()) {
				c1.setReason(" only Retail data found");
				c1.setStatus(3);
			} else {
				c1.setStatus(-1);
				c1.setReason(" no item found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c1;

	}

	public CResult getCustomerDetails(String mobile_no) {
		CResult c1 = new CResult(0, new Invoices(), "failed due to user");
		try {
			Invoices invo = ir.searchByMobileNo(mobile_no);

			if (invo == null) {
				c1.setReason("Supplier not found");
			} else {
				System.out.println("heyy");

				c1.setReason("Success");
				c1.setStatus(1);
				c1.setContentinvoice(invo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

	@Override // Shubham
	public CResult insertListofItemsale(List<ItemSale> list) {
		// TODO Auto-generated method stub
		CResult c1 = new CResult(0, "failed due to user");
		try {
			isr.saveAll(list); // insert into ITEM_SALES table.
			c1.setStatus(1);
			c1.setReason("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;

	}

//insertInvoice function done by shubham
	@Override
	public CResult insertInvoices(Invoices invoice) {
		// TODO Auto-generated method stub
		CResult c1 = new CResult(0, new Invoices(), "failed due to user");
		try {
			ir.save(invoice);// changed by sandipan
			c1.setStatus(1);
			c1.setContentinvoice(invoice);
			c1.setReason("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

	@Override
	public CResult updateItemQuantity(List<Inventory> updateQuantityList) {
		CResult c1 = new CResult(0, "nothing done");
		int count = 0;
		int success = 0;
		try {
			for (int i = 0; i < updateQuantityList.size(); i++) {
				success = ar.f1(updateQuantityList.get(i).getQuantity(), updateQuantityList.get(i).getItem_code());
				count += success;
			}

			if (count == updateQuantityList.size()) {
				c1.setReason("success");
				c1.setStatus(1);
				System.out.println(count);
			} else {
				c1.setReason("failed to update: " + (updateQuantityList.size() - count));
				c1.setStatus(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c1;
	}

//============================================User==============================
	@Override
	public UResult registerEmployee(Employee emp) {
		UResult ur = new UResult(0, "Failed");
		try {
			if (er.count() == 0) {
				emp.setEmpId(String.valueOf(er.count() + 1001));
				emp.setPrivilege("ADMIN");
				er.save(emp);
				ur.setStatus(2);
				ur.setReason("Administrator registered with employee ID: " + emp.getEmpId());
			} else {
				emp.setEmpId(String.valueOf(er.count() + 1001));
				emp.setPrivilege("NOT SET");
				er.save(emp);
				ur.setStatus(1);
				ur.setReason("Your employee ID is: " + emp.getEmpId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public UResult login(String empId, String password) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		UResult ur = new UResult(0, employee, "Failed");
		try {
			Optional<Employee> emp = er.findById(empId);
			if (emp.isPresent()) {
				employee = emp.get();
				if (employee.getPassword().equals(password)) {
					ur.setEmployee(employee);
					ur.setStatus(1);
					ur.setReason("Login Sucess!!");
				} else {
					ur.setStatus(-1);
					ur.setReason("Incorrect Password");
				}
			} else {
				ur.setStatus(-2);
				ur.setReason("Employee Not Found!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public CResult getPurchaseReport(String startDate, String endDate) {
		CResult c1 = new CResult(0, "Failed");
		try {
			List<SupplierRecord> li = sr.getPurhcaseReport(startDate, endDate);
			if (li.isEmpty()) {
				c1.setStatus(-1);
				c1.setReason("No data found");
			} else {
				c1.setStatus(1);
				c1.setReason("Success");
				c1.setSupplierdtls(li);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

	@Override
	public CResult getSalesReport(String startDate, String endDate) {
		CResult c1 = new CResult(0, "Failed");
		try {
			List<Invoices> li = ir.getSalesReport(startDate, endDate);
			if (li.isEmpty()) {
				c1.setStatus(-1);
				c1.setReason("No data found");
			} else {
				c1.setStatus(1);
				c1.setReason("Success");
				c1.setInvoiceList(li);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}

	public UResult getListOfEmployees() {
		List<Employee> empList = new ArrayList<>();
		UResult ur = new UResult(0, empList, "Failed");
		try {
			empList = er.findAll();
			ur.setStatus(1);
			ur.setReason("sucess");
			ur.setEmpList(empList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public UResult updateEmployeeDetails(Employee emp) {
		System.out.println(emp);
		UResult ur = new UResult(0, "Failed");
		emp.setPassword(emp.getPassword());
		try {
			er.save(emp);
			ur.setStatus(1);
			ur.setReason("Successfully updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public UResult getEmployeeDetails(String empId) {
		Employee emp = new Employee();
		UResult ur = new UResult(0, emp, "Failed");
		try {
			Optional<Employee> o = er.findById(empId);
			if (o.isPresent()) {
				emp = o.get();
				ur.setStatus(1);
				ur.setReason("Employee found");
				ur.setEmployee(emp);
			} else {
				ur.setStatus(-1);
				ur.setReason("Employee not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}

}