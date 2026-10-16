package ie.atu.cicd1.catalog.Repository;

import ie.atu.cicd1.catalog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
