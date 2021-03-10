package inb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.Inventory;
import inb.models.SupplierRecord;


@Repository
public interface SupplierRecordRepository extends JpaRepository<SupplierRecord, String> {
	@Query("from SupplierRecord where supplier_name like :str%")
	public List<SupplierRecord> f1(@Param("str") String supplier_name);
}
