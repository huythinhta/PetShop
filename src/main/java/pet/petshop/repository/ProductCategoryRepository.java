package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Productcategories;

public interface ProductCategoryRepository extends JpaRepository<Productcategories, Integer> {

}
