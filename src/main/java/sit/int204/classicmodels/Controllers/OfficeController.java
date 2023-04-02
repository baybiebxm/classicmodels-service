package sit.int204.classicmodels.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.entities.Employee;
import sit.int204.classicmodels.entities.Office;
import sit.int204.classicmodels.services.OfficeService;
import java.util.List;
import java.util.Set;

@RestController     // ไว้คุยกับ front-end  ; มี endpoint รองรับ
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office> getOffices(){
        return service.getAllOffices();
    }

    @GetMapping("/{officeCode}")
    public Office getOffice(@PathVariable String officeCode){   // PathVariable : ดึงข้อมูลตัวแปร officeCode แปลงเป็น String
        return service.getOffice(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployees(@PathVariable String officeCode){
        return service.getOfficeEmployee(officeCode);
    }

    @PostMapping("")
    public Office createOffice(@RequestBody Office office){
        return service.createOffice(office);       // รับ RequestBody แปลง json -> java
    }

    @PostMapping("/{officeCode}/employees")
    public Employee createEmployee(@PathVariable String officeCode, @RequestBody Employee employee){
        return service.createEmployee(officeCode, employee);
    }

    @PutMapping("/{officeCode}")     // RequestBody : object json -> object java
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode){
        return service.updateOffice(officeCode, office);    // send to service
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode){
        service.removeOffice(officeCode);
    }



}
