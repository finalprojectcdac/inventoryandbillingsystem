package inb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inb.models.SupplierRecord;


@Repository
public interface SupplierRecordRepository extends JpaRepository<SupplierRecord, String> {
	@Query("from SupplierRecord where supplier_name like :str%")
	public List<SupplierRecord> f1(@Param("str") String supplier_name);

	@Query(nativeQuery=true, value="select supplier_name,supplier_code,supplier_invoice_value,supplier_invoice_number,purchase_date from supplier_record where supplier_name= :str limit 1")
	public SupplierRecord f2(@Param("str") String supplier_name);
	
	@Query(nativeQuery=true, value="select supplier_invoice_number,purchase_date, supplier_code, supplier_invoice_value, supplier_name from supplier_record where purchase_date between :sd and :ed")
	public List<SupplierRecord> getPurhcaseReport(@Param("sd") String startDate, @Param("ed") String endDate);
}

