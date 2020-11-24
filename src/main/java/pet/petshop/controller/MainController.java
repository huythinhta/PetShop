package pet.petshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.Product;
import pet.petshop.service.ProductService;

@Controller
public class MainController {
	private ProductService ps;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	 @GetMapping("/") 
	 public String home() { return "index4"; }
	 

	
	
	
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
	
}
