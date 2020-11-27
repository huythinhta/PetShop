package pet.petshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);

	List<User> findAllByEmailContaining(String email);

}
