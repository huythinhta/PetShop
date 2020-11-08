package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.servicecategories;
import pet.petshop.repository.servicecategoriesRespository;

@Service
public class servicecategoriesService {
	@Autowired
	private servicecategoriesRespository spo;
	
	public List<servicecategories> listAll(){
		return spo.findAll();
	}
	
	public void save(servicecategories servicecategories)
	{
		spo.save(servicecategories);
	}
	
	public servicecategories get(Integer id)
	{
		return spo.findById(id).get();
	}
	public void delete(Integer id) {
		spo.deleteById(id);
	}
}
