package sit.int204.classicmodels.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String id;
    @Column(name = "productName", nullable = false, length = 70)
    private String name;
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;
    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;
    @Column(name = "productDescription", nullable = false, length = 65535)
    private String Description;
    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;
    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private Double price;
    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private Double msrp;

    public String getImageUrl(){
        return id+".jpg";
    }

}
