package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.petshop.entity.Productcategories;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<Productcategories, Integer> {

    List<Productcategories> findAllByNameContaining(String name);

}
