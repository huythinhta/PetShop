package pet.petshop.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pet.petshop.dto.UserRegistrationDto;
import pet.petshop.entity.Role;
import pet.petshop.entity.User;
import pet.petshop.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
<<<<<<< HEAD
	public User Regis(User registrationDto) {
		User user = new User(registrationDto.getEmail(), 
				passwordEncoder.encode(registrationDto.getPassword()), "ROLE_USER");
=======

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
>>>>>>> 4232a0a1159f910c5caf19b17da33bc2d0cb3fb0
		
		return userRepository.save(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
<<<<<<< HEAD
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public void save(User ur) {
		User user = new User(ur.getEmail(),passwordEncoder.encode(ur.getPassword()),ur.getRole());
		userRepository.save(user);
	}
	
	public User get(int id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
=======
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
>>>>>>> 4232a0a1159f910c5caf19b17da33bc2d0cb3fb0
	
}
