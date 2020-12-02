package pet.petshop.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;



import pet.petshop.service.ProductService;
@Controller
public class MainController {
	@Autowired
	private ProductService ps;
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	 
	@GetMapping("/home")
	public String home1() {
		return "index5";
	}
	
	@GetMapping("/home1")
	public String home11() {
		return "test";
	}
	@GetMapping("/admin")
	public String home2() {
		return "index3";
	}
	@GetMapping("/")
	public String Index(ModelMap model) {
		model.put("product",ps.listAll());
		return "indexnotlogin";
	}
	
}
