package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.entity.Bill;
import pet.petshop.entity.User;
import pet.petshop.repository.BillRepository;

@Service
@Transactional
public class BillService {
	@Autowired
	private BillRepository br;
	
	public List<Bill> listAll(){
		return br.findAll();
	}
	
	public void save(Bill bill) {
		br.save(bill);
	}
	
	public Bill get(int id) {
		return br.findById(id).get();
	}
	
	public void delete(int id) {
		br.deleteById(id);
	}
	
	public List<Bill> BillByUser(User user){
		return br.findByUser(user);
	}
	 
	
}
