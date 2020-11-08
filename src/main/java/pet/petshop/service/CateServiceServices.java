package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.CateService;
import pet.petshop.repository.CateServiceRespository;

@Service
public class CateServiceServices {
	@Autowired
	private CateServiceRespository service;
	
	public List<CateService> ListALL(){
		return service.findAll();
	}
	
	public void save(CateService cateservice) {
		service.save(cateservice);
	}
	
	public CateService get(Integer id) {
		return service.findById(id).get();
	}
	
	public void delete (Integer id) {
		service.deleteById(id);
	}
}
