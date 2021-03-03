package inb.service;

import java.util.List;

import inb.models.CResult;
import inb.models.Inventory;

public interface ServiceInterface {

	CResult addItem(Inventory item);
	CResult addMultipleItems(List<Inventory> item);

}
