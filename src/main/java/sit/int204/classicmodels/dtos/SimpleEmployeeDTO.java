package sit.int204.classicmodels.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleEmployeeDTO {
    private String firstname;
    private String lastName;
    private String email;
    private String officeId;

    public String getName(){
        return firstname + " " + lastName;
    }
}
