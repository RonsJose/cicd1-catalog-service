package ie.atu.cicd1.catalog.Service;

import ie.atu.cicd1.catalog.Model.Product;
import ie.atu.cicd1.catalog.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }
}
