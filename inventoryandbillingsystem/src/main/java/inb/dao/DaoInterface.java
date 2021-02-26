package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inb.models.Inventory;



@Repository
public interface DaoInterface extends JpaRepository<Inventory, String> {

	
	
}
