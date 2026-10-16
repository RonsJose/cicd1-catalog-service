package ie.atu.cicd1.catalog.Service;

import ie.atu.cicd1.catalog.Model.Category;
import ie.atu.cicd1.catalog.Model.Product;
import ie.atu.cicd1.catalog.Repository.CategoryRepository;
import ie.atu.cicd1.catalog.Repository.ProductRepository;
import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(CreateProductRequest request) {
        if(request.categoryId()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Category Id is required");
        }
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Category does not exist"));

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"
                ));
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinimumPrice(minPrice);
    }

    public List<Product> getByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public List<Product> getByMaximumPrice(BigDecimal maxPrice) {
        return productRepository.findByMaxPrice(maxPrice);
    }
}
