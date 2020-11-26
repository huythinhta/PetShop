package pet.petshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pet.petshop.service.ProductService;
@Controller
public class MainController {
	
	
	
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
	public String Index() {
		return "indexnotlogin";
	}
	
}
