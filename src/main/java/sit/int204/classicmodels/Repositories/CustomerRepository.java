package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.entities.Customer;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByContactFirstNameContainingIgnoreCase(String username);
}
