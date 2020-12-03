package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
