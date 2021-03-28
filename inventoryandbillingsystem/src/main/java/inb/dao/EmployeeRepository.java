package inb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import inb.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
}
