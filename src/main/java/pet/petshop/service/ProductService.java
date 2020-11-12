package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Product;
import pet.petshop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pr;
	
	public List<Product> listAll(){
		return pr.findAll();
	}
	
	public void save(Product product) {
		pr.save(product);
	}
	
	public Product get(Integer id) {
		return pr.findById(id).get();
	}
	
	public void delete(Integer id) {
		pr.deleteById(id);
	}
}
