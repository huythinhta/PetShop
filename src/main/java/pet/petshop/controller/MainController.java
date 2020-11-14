package pet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index4";
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
