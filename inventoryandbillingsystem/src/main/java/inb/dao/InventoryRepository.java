package inb.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inb.models.Inventory;
//import inb.models.SupplierRecord;




@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {


//	@Query("from inventory where balance < :msoc")
//	public List<Inventory> f1(@Param("msoc") int quantity);
	

	@Modifying
	@Query( nativeQuery= true,value="update inventory set quantity = :qty  where item_code = :itmcd")
	@Transactional
	public int f1(@Param("qty") int quantity , @Param ("itmcd")  String item_code);
	
	
	
	
	
	
	

}

