package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>{
	
}
