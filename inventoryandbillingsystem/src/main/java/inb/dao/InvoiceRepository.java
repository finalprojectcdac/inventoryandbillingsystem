package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;



import inb.models.Invoices; 

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, String>{


  @Query(nativeQuery = true, value = "select invoice_no, customer_name, email_id, invoice_value, mobile_no from invoices where mobile_no= :str")
   public Invoices searchByMobileNo(@Param("str") String mobile_no); 


}
