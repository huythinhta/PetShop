package pet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Product;

public interface ProductResopository2 extends JpaRepository<Product, Integer> {
	List<Product> getProductsByNameContains(String search);
}
