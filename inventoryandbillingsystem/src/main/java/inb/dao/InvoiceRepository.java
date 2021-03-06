package inb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import inb.models.Invoices; 

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, String>{


	@Query(nativeQuery=true, value="select count(*)+1001 from invoices")
	public int f1();


  @Query(nativeQuery = true, value = "select invoice_no, customer_name, email_id, invoice_value, mobile_no, billing_date from invoices where mobile_no= :str limit 1")
   public Invoices searchByMobileNo(@Param("str") String mobile_no);
  
  @Query(nativeQuery = true, value = "select sum(invoice_value) from invoices where billing_date = current_date()")
  public String todaysSale();

  @Query(nativeQuery = true, value = "select invoice_no, billing_date, customer_name, email_id, invoice_value, mobile_no from invoices where billing_date between :sd and :ed")
  public List<Invoices> getSalesReport(@Param("sd") String startDate, @Param("ed") String endDate);
}
