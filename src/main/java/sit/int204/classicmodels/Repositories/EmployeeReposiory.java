package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.entities.Employee;

public interface EmployeeReposiory extends JpaRepository<Employee, Integer> {
}
