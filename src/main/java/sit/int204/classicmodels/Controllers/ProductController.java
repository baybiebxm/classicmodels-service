package sit.int204.classicmodels.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.entities.Product;
import sit.int204.classicmodels.services.ProductService;

import java.awt.geom.QuadCurve2D;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }

    @GetMapping("/pages")
    public Page<Product> getProductPage(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ){
        return service.getProductinPage(page, pageSize, sortBy);
    }

    @GetMapping("{productCode}")
    public Product getProduct(@PathVariable String productCode){
        return service.getProduct(productCode);
    }

    @GetMapping("/{productLine}/{sortBy}")
    public List<Product> getProductLine(@PathVariable String productLine,@PathVariable String sortBy){
        return service.getSortProductLine(productLine, sortBy);
    }

    @GetMapping("price/{min}/{max}")
    public List<Product> findByPriceBetween(@PathVariable double min,@PathVariable double max){
        return service.findAllByPrice(min, max);
    }

    @PutMapping("{productCode}")    // RequestBody : object json -> object java
    public Product updateProduct(@RequestBody Product product, @PathVariable String productCode){
        return service.updateProduct(productCode,product);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return service.createNewProduct(product);
    }
}
