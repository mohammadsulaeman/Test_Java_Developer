package test.java.developer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.java.developer.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
