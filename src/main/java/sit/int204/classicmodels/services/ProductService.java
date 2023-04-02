package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodels.Repositories.ProductRepository;
import sit.int204.classicmodels.entities.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProduct(String productCode){
        return repository.findById(productCode).orElseThrow(
                () -> new RuntimeException (productCode + " dose not exist!!!")
        );
    }

    public Page<Product> getProductinPage(int page, int size, String sortBy){
        try {
            Sort sort = Sort.by(sortBy);        // สร้าง object Sort ; field ที่ต้องการจะ sort
            Pageable pageable = PageRequest.of(page, size, sort);      // PageRequest สร้าง object ของ Pageable
            return repository.findAll(pageable);
        }
        catch (Exception e){
            throw new RuntimeException(sortBy + " is not a valid field name.");
        }
    }

    public List<Product> getSortProductLine(String productLine, String sortBy){
        Sort sort = Sort.by(sortBy);
        List<Product> results = repository.findAllByProductLineContainingIgnoreCase(productLine, sort);
        if(results.isEmpty()){
            throw new RuntimeException("This product line is not exist!");
        }
        return repository.findAllByProductLineContainingIgnoreCase(productLine,sort);
    }

    public List<Product> findAllByPrice(double min, double max){
        List<Product> results = repository.findAllByPriceBetween(min, max);
        if(results.isEmpty()){
            throw new RuntimeException("The value of price is not exist");
        }
        if(min > max){
            throw new RuntimeException("The price of " + max + " cannot less than " + min + ", The POSITION should be change.");
        }
        return repository.findAllByPriceBetween(min, max);
    }

    public Product updateProduct(String productCode, Product product){
        Product existProduct = repository.findById(productCode).orElseThrow(
                () -> new RuntimeException(productCode + " dose not exist!!!")
        );
        try {
            existProduct.setPrice(product.getPrice());
            existProduct.setName(product.getName());
            return repository.saveAndFlush(existProduct);
        }
        catch (Exception e){
            throw new RuntimeException("Some fields that have not been mentioned yet.");
        }
    }

    public Product createNewProduct(Product product){
        try {
            return repository.saveAndFlush(product);
        }
        catch (Exception e){
            throw new RuntimeException("The property cannot be null, Please check that every information has been added.");
        }
    }
}
