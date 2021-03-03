package inb.service;

import inb.models.CResult;
import inb.models.Inventory;
import inb.models.SupplierRecord;

public interface ServiceInterface {

	CResult addItem(Inventory item);
	CResult RegisterSupplier(SupplierRecord s);
	CResult updateQuantity(Inventory item );
}
