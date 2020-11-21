package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Product;

import java.util.List;

public interface ProductRespository extends JpaRepository<Product, Integer> {

    List<Product> getProductsByNameContains(String search);

}
