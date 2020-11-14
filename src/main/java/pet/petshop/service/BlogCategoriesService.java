package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Blogcategories;
import pet.petshop.repository.BlogCategoriesRespository;

@Service
public class BlogCategoriesService {
	@Autowired
	private BlogCategoriesRespository bcpo;
	
	public List<Blogcategories> listALL(){
		return bcpo.findAll();
	}
	
	public void save(Blogcategories blogcategories) {
		bcpo.save(blogcategories);
	}
	
	public Blogcategories get(Integer id) {
		return bcpo.findById(id).get();
	}
	
	public void delete(Integer id) {
		bcpo.deleteById(id);
	}
}
