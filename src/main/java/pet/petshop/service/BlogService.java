package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Blog;
import pet.petshop.repository.blogRespository;

@Service
public class BlogService {
	@Autowired
	private blogRespository bpo;
	
	public List<Blog> listALL(){
		return bpo.findAll();
	}
	
	public void save(Blog blog) {
		bpo.save(blog);
	}
	
	public Blog get(Integer id) {
		return bpo.findById(id).get();
	}
	
	public void delete(Integer id) {
		bpo.deleteById(id);
	}
}
