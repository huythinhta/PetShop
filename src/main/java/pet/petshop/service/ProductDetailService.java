package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Blog;
import pet.petshop.entity.Productdetail;
import pet.petshop.repository.ProductDetailRepository;
import pet.petshop.repository.blogRespository;

@Service
public class ProductDetailService {
	@Autowired
	private ProductDetailRepository pdr;
	
	public List<Productdetail> listALL(){
		return pdr.findAll();
	}
	
	public void save(Productdetail productdetail) {
		pdr.save(productdetail);
	}
	
	public Productdetail get(Integer id) {
		return pdr.findById(id).get();
	}
	
	public void delete(Integer id) {
		pdr.deleteById(id);
	}
}
