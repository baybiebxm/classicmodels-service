package sit.int204.classicmodels.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodels.Repositories.EmployeeReposiory;
import sit.int204.classicmodels.dtos.SimpleEmployeeDTO;
import sit.int204.classicmodels.entities.Employee;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeReposiory repository;       // inject เอา object ของ repository มาเก็บเอาไว้ เพื่อจะได้ entity มาใช้ ; ส่งไปให้ controller
    // เอา object มาเก็บไว้ใน attribute เวลาเขียน method จะได้เรียกใช้ได้   ; service ตอบโจทย์ endpoint
    @Autowired
    private ModelMapper modelMapper;
//    public List<Employee> getAllEmployees(){
//        return repository.findAll();
//    }

    public Employee getEmployee(String employeeNumber){
        return repository.findById(Integer.valueOf(employeeNumber)).orElseThrow(
                () -> new RuntimeException(employeeNumber + " dose not exist!!")
        );
    }

    public Employee updateEmployee(Integer employeeNumber, Employee employee){
        Employee existEmp = repository.findById(employeeNumber).orElseThrow(
                () -> new RuntimeException(employeeNumber + " dose not exist!!!")
        );
        existEmp.setFirstName(employee.getFirstName());
        existEmp.setLastName(employee.getLastName());
        return repository.saveAndFlush(existEmp);
    }

    public void removeEmployee(Integer employeeNumber){
        Employee emp = getEmployee(String.valueOf(employeeNumber));
        repository.delete(emp);
    }

//    public List<SimpleEmployeeDTO> dtos = getAllEmployees().stream().map(employee ->
//            modelMapper.map(employee, SimpleEmployeeDTO.class)).collect(Collectors.toList());

    public Employee saveCreateEmp(Employee employee){
        return repository.saveAndFlush(employee);
    }
}
