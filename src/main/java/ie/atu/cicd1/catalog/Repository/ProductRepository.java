package ie.atu.cicd1.catalog.Repository;

import ie.atu.cicd1.catalog.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
