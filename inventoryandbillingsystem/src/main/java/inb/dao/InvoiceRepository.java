package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import inb.models.Invoices;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, String>{
	@Query(nativeQuery=true, value="select count(*)+1 from invoices")
	public int f1();
}
