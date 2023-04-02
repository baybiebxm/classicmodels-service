package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.int204.classicmodels.Repositories.EmployeeReposiory;
import sit.int204.classicmodels.Repositories.OfficeRepository;
import sit.int204.classicmodels.entities.Employee;
import sit.int204.classicmodels.entities.Office;
import sit.int204.classicmodels.exceptions.ResourceNotFound;

import java.util.List;
import java.util.Set;

@Service
public class OfficeService {

    @Autowired
    private EmployeeReposiory employeeReposiory;
    @Autowired
    private OfficeRepository repository;    // inject เอา object ของ repository มาเก็บเอาไว้ เพื่อจะได้ entity มาใช้ ; ส่งไปให้ controller
    // เอา object มาเก็บไว้ใน attribute เวลาเขียน method จะได้เรียกใช้ได้   ; service ตอบโจทย์ endpoint
    public List<Office> getAllOffices() {
        return repository.findAll();
    }

    public Office getOffice(String officeCode){
//        return repository.findById(officeCode).orElseThrow(
//                () -> new RuntimeException(officeCode + " dose not exist!!")
//        );
        return repository.findById(officeCode).orElseThrow(
                () -> new ResourceNotFound(officeCode + " dose not exist!!")
        );
    }

    public Set<Employee> getOfficeEmployee (String officeCode){
        Office office = getOffice(officeCode);
        return office.getEmployees();
    }

    public Office createOffice(Office office){
        return repository.saveAndFlush(office); //ส่ง object ไป
    }

    public Office updateOffice(String officeCode, Office office){
        Office existOffice = repository.findById(officeCode).orElseThrow(
                () -> new RuntimeException(officeCode + " dose not exist!!!")
        );
        existOffice.setCity(office.getCity());
        existOffice.setPhone(office.getPhone());
        return repository.saveAndFlush(existOffice);
    }

    public void removeOffice(String officeCode){
        Office office = getOffice(officeCode);
        repository.delete(office);
    }

    public Employee createEmployee(String officeCode,Employee employee) {
        Office office = getOffice(officeCode);
        employee.setOffice(office);
        return employeeReposiory.saveAndFlush(employee);
    }
}
