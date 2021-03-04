package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inb.models.SupplierRecord;

@Repository
public interface SupplierRecordRepository extends JpaRepository<SupplierRecord, String> {

}
