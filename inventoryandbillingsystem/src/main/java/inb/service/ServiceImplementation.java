package inb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inb.dao.DaoInterface;
import inb.models.CResult;
import inb.models.Inventory;


@Service
public class ServiceImplementation implements ServiceInterface {
	
	@Autowired
	private DaoInterface ar;
	
	
	public CResult addItem(Inventory item)
	{
		CResult c1 =new CResult(0, item, "failed due to user");
		try {
			ar.save(item);
			c1.setStatus(1);
			c1.setReason("success");
			System.out.println(item);
		} catch (Exception e) {
			System.out.println("if if fails we think why");
		}
		
		return c1;
	}


	@Override //created by vaibhav
	public CResult addMultipleItems(List<Inventory> lsi) {
		CResult c1 = new CResult(0, null, "failed due to user");
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

}
