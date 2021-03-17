package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.ItemSale;


@Repository
public interface ItemSaleRepository extends JpaRepository<ItemSale, Integer>{
	
}
