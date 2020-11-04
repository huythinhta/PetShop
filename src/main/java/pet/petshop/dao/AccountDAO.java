package pet.petshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Account;
import pet.petshop.repository.AccountRepository;

@Service
public class AccountDAO {
	@Autowired
	private AccountRepository ar;

	public List<Account> list() {
		return ar.findAll();
	}
	public void delete(String username) {
		ar.deleteById(username);
	}
	public Account get(String username) {
		
		return ar.findById(username).get();
	}
	public void save(Account account) {
		ar.save(account);
	}

}
