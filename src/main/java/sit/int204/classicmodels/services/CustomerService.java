package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodels.Repositories.CustomerRepository;
import sit.int204.classicmodels.entities.Customer;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(Integer customerNumber){
//        Customer customer = repository.findById(customerNumber).orElseThrow();
        return repository.findById(customerNumber).orElseThrow( ()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer ID " +  customerNumber + " Does Not Exist!!!"));
    }

    public Page<Customer> getCustomerWithPagination(int page, int size){
        return repository.findAll(PageRequest.of(page,size));
    }

    public List<Customer> findByUsername(String username){
        return repository.findAllByContactFirstNameContainingIgnoreCase((username));
    }
}
