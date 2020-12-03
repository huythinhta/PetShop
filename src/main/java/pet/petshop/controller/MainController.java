package pet.petshop.controller;


import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;



import pet.petshop.service.ProductService;
import pet.petshop.service.UserService;
import pet.petshop.service.UserServiceImpl;
import pet.petshop.service.UsersService;
import pet.petshop.entity.User;
@Controller
public class MainController {
	@Autowired
	private ProductService ps;
	@Autowired 
	private UserServiceImpl us;
	
	
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
	public String Index(ModelMap model,HttpSession session,Principal principal) {
		model.put("product",ps.listAll());
		if (principal != null) {
			User user = us.loadUserByUsername2(principal.getName());
			session.setAttribute("user",user);
		}
		return "indexnotlogin";
	}
	
}
