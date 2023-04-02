package sit.int204.classicmodels.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.Repositories.EmployeeReposiory;
import sit.int204.classicmodels.dtos.SimpleEmployeeDTO;
import sit.int204.classicmodels.entities.Employee;
import sit.int204.classicmodels.services.EmployeeService;
import sit.int204.classicmodels.utils.ListMapper;

import java.util.List;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeReposiory repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper   ;

//    @GetMapping("")
//    public List<Employee> getAllEmployees(){
//        return service.getAllEmployees();
//    }

    @GetMapping("/{employeeNumber}")
    public Employee getEmployee(@PathVariable Integer employeeNumber){
        return service.getEmployee(String.valueOf(employeeNumber));
    }

    @PutMapping("/{employeeNumber}")     // RequestBody : object json -> object java
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeNumber){
        return service.updateEmployee(employeeNumber, employee);    // send to service
    }

    @DeleteMapping("/{employeeNumber}")
    public void removeEmployee(@PathVariable Integer employeeNumber){
        service.removeEmployee(employeeNumber);
    }

    @GetMapping("")
    public List<SimpleEmployeeDTO> getEmployees(){
        List<Employee> employeeList = repository.findAll();
        return listMapper.mapList(employeeList, SimpleEmployeeDTO.class, modelMapper);     // สร้าง mapList แล้ว
//                employeeList.stream()
//                .map(e -> modelMapper.map(e, SimpleEmployeeDTO.class))
//                .collect(Collectors.toList());
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody SimpleEmployeeDTO newEmployee){
        Employee e = modelMapper.map(newEmployee, Employee.class);
        return service.saveCreateEmp(e);
    }
}
