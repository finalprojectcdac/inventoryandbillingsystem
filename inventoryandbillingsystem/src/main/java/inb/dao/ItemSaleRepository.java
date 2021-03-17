package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.ItemSale;


@Repository
public interface ItemSaleRepository extends JpaRepository<ItemSale, Integer>{
	@Query(nativeQuery=true, value="SELECT sno FROM item_sale\r\n"
			+ "ORDER BY sno DESC\r\n"
			+ "LIMIT 1;")
	public int f1();
}
