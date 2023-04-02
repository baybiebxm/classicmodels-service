package sit.int204.classicmodels.Repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>{
    List<Product> findAllByPriceBetween(double min, double max);
    List<Product> findAllByProductLineContainingIgnoreCase(String productLine, Sort sort);


}
