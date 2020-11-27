package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Services;

import java.util.List;

public interface ServiceRespository extends JpaRepository<Services, Integer> {

    List<Services> findAllByNameContaining(String name);

}
