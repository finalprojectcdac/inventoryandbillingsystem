package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.Inventory;
import inb.models.RetailPriceData;

@Repository
public interface RetailPriceDataRepository extends JpaRepository<RetailPriceData, String> {

	@Query(nativeQuery=true, value="select count(item_code) from retail_price_data where selling_price = -1")
	public int f1();
	
	

}
