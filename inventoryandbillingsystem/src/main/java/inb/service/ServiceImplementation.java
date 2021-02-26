package inb.service;

import org.springframework.stereotype.Service;

import inb.models.CResult;
import inb.models.Inventory;

@Service
public class ServiceImplementation implements ServiceInterface {

	@Override
	public CResult addItem(Inventory item) {
		// TODO Auto-generated method stub
		CResult c1 =new CResult(0, item, "failed due to user");
		try {
			//ar.save(c);
			c1.setStatus(1);
			c1.setReason("success");
			//item.toString();
			System.out.println(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("if if fails we think why");
		}
		
		return c1;
	}

}
