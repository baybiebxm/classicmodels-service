package sit.int204.classicmodels.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "offices")
@JsonRootName("Office")
public class Office {
    @Id
    @Column(name = "officeCode", nullable = false, length = 10)
    private String id;
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;
    @Column(name = "addressLine2", nullable = false, length = 50)
    private String addressLine2;
    @Column(name = "state", nullable = false, length = 50)
    private String state;
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    @Column(name = "postalCode", nullable = false, length = 15)
    private String postalCode;
    @Column(name = "territory", nullable = false, length = 10)
    private String territory;

    @JsonIgnore  // when ขอ office ; each office จะเอา employees ใส่เข้ามาด้วย ; ignore ไม่เอา field นี้ใส่ไปให้ json เวลาส่งไปให้ front-end
    @OneToMany(mappedBy = "office")     // map to Employee with field 'office'
    private Set<Employee> employees = new LinkedHashSet<>();
}
