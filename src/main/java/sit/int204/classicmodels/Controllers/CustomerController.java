package sit.int204.classicmodels.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodels.dtos.PageDTO;
import sit.int204.classicmodels.dtos.SimpleCustomerDTO;
import sit.int204.classicmodels.entities.Customer;
import sit.int204.classicmodels.services.CustomerService;
import sit.int204.classicmodels.utils.ListMapper;
import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

//    @GetMapping("")
//    public List<Customer> getAllCustomers(){
//        return service.getCustomers();
//    }

    @GetMapping("/{customerNumber}")
    public SimpleCustomerDTO getSimpleCustomerById(@PathVariable Integer customerNumber){
        return modelMapper.map(service.getCustomerById(customerNumber), SimpleCustomerDTO.class);  // แปลงไป SimpleCustomerDTO
    }
    @GetMapping("")
    public List<SimpleCustomerDTO> getSimpleCustomer(){
        List<Customer> customerList = service.getCustomers();
//        List<SimpleCustomerDTO> customerDtolist =customerList.stream().map(c -> modelMapper.map(c, SimpleCustomerDTO.class)).collect(Collectors.toList());
        return listMapper.mapList(customerList, SimpleCustomerDTO.class, modelMapper);
    }

    @GetMapping("/pages")
    public PageDTO<SimpleCustomerDTO> getSimpleCustomerWithPagination(){
        Page<Customer> customerList = service.getCustomerWithPagination(1   ,5);
        return listMapper.toPageDTO(customerList, SimpleCustomerDTO.class,modelMapper);
    }

    @GetMapping("/user/{contactFirstname}")
    public List<Customer> getUserByUsername(@PathVariable String contactFirstname){
        return service.findByUsername(contactFirstname);
    }
}
