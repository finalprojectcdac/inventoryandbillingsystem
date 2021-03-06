package inb.service;

import java.util.List;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.Invoices;
import inb.models.SupplierRecord;

public interface ServiceInterface {

	//CResult addItem(Inventory item);this was for testing 
	CResult addMultipleItems(List<Inventory> item);
	CResult RegisterSupplier(SupplierRecord s);
	CResult updateQuantity(Inventory item );
	CResult addInvoices(Invoices invoice);
}
