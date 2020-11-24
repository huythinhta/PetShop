package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Productcategories;
import pet.petshop.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	@Autowired
	private ProductCategoryRepository pcpo;
	
	public List<Productcategories> listALL(){
		return pcpo.findAll();
	}
	
	public void save(Productcategories productcategories) {
		pcpo.save(productcategories);
	}
	
	public Productcategories get(Integer id) {
		return pcpo.findById(id).get();
	}
	
	public void delete(Integer id) {
		pcpo.deleteById(id);
	}

	public List<Productcategories> findCategoriesByName(String name){
		return pcpo.findAllByNameContaining(name);
	};
}
