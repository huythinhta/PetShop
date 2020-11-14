package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}
