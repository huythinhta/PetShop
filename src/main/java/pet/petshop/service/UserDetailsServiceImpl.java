package pet.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pet.petshop.dao.AccountDAO;
import pet.petshop.entity.Account;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	AccountDAO dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc= dao.get(username);
		List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
		if(acc==null) {
			System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
		if(acc!=null) {
			System.out.println("Found User: " + acc);
			if(acc.isRole()==true) {
				GrantedAuthority autho= new SimpleGrantedAuthority("ROLE_ADMIN");
				ga.add(autho);
			}else {
				GrantedAuthority autho= new SimpleGrantedAuthority("ROLE_USER");
				ga.add(autho);
			}
			
		}
		UserDetails userDetails = (UserDetails) new User(acc.getUsername(), acc.getPassword(),ga);
		return userDetails;
	}

}
