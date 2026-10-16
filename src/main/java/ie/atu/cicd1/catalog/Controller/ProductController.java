package ie.atu.cicd1.catalog.Controller;

import ie.atu.cicd1.catalog.Model.Product;
import ie.atu.cicd1.catalog.Service.ProductService;
import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody CreateProductRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/min-price")
    public List<Product> getByMinimumPrice(
            @RequestParam("price") BigDecimal price) {
        return service.getByMinimumPrice(price);
    }

    @GetMapping("/by-category")
    public List<Product> getByCategory(
            @RequestParam("name") String categoryName) {
        return service.getByCategoryName(categoryName);
    }

}