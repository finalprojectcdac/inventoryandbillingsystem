package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inb.models.RetailPriceData;

@Repository
public interface RetailPriceDataRepository extends JpaRepository<RetailPriceData, String> {

}
