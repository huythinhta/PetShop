package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Blogcategories;

public interface BlogCategoriesRespository extends JpaRepository<Blogcategories, Integer> {

}
