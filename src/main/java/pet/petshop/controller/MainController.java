package pet.petshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.User;
import pet.petshop.service.ProductService;
import pet.petshop.service.UserServiceImpl;
import pet.petshop.service.UsersService;

@Controller
public class MainController {
	
	@Autowired
	private UserServiceImpl us;
	@Autowired
	private UsersService uss;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/changepassword")
	public String changePassword(ModelMap model,HttpSession session) {
		model.addAttribute("user",session.getAttribute("user"));
		return "changepassword";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user) {
		String encodepass = passwordEncoder().encode(user.getPassword());
		user.setPassword(encodepass);
	    uss.save(user);
	    return "redirect:/";
	}
	
	
	
	
	@GetMapping("/admin")
	public String home2() {
		return "admin/index3";
	}
	
	
	
}
