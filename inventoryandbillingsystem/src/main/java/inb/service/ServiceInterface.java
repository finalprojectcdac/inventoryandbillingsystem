package inb.service;

import java.util.List;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.SupplierRecord;

public interface ServiceInterface {

	CResult addItem(Inventory item);
	CResult addMultipleItems(List<Inventory> item);
	CResult RegisterSupplier(SupplierRecord s);
	CResult updateQuantity(Inventory item );
}
