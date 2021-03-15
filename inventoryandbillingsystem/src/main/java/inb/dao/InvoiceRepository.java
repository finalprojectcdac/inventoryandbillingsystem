package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inb.models.Invoices;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, String>{

}
