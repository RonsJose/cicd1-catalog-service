package ie.atu.cicd1.catalog.Service;

import ie.atu.cicd1.catalog.Model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public List<Product> getAll() {
        return products;
    }

    public Product create(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;

