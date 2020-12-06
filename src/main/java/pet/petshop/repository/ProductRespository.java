package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import pet.petshop.entity.Product;

import java.util.List;


public interface ProductRespository extends JpaRepository<Product, Integer> {

    List<Product> getProductsByNameContains(String search);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% AND p.brand LIKE ?2")
    List<Product> getProductsByNameContainsAndBrand(String search, String branch);

}
