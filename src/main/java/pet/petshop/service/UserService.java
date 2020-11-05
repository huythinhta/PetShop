package pet.petshop.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import pet.petshop.dto.UserRegistrationDto;
import pet.petshop.entity.User;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
