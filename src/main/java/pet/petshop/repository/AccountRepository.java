package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
