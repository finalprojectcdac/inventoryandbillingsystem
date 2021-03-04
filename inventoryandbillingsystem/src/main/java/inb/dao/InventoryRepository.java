package inb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.Inventory;




@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

//	@Query("from inventory where balance < :msoc")
//	public List<Inventory> f1(@Param("msoc") int quantity);
	
}
