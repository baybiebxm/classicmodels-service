package sit.int204.classicmodels.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleCustomerDTO {
    private String customerName;
    private String contactFirstname;
    private String contactLastname;
    private String phone;
    private String city;
    private String country;
//    public String getCountry(){
//        return country.toUpperCase();
//    }
    @JsonIgnore
    private SimpleEmployeeDTO salesRepEmployee;
    public String getSalesPerson(){
        return salesRepEmployee == null ? "-" :salesRepEmployee.getName();
    }

}
