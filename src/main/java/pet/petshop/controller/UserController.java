package pet.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Bill;
import pet.petshop.entity.User;
import pet.petshop.service.UsersService;

@Controller
//@RequestMapping("/User")
public class UserController {
	@Autowired
	private UsersService us;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	
	@RequestMapping("/user")
	public String index(Model model) {
		List<User> list = us.listAll();
		model.addAttribute("users",list);
		return "admin/user/index";
	}
	
	@RequestMapping("/new")
	public String showNewUserPage(Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	     
	    return "admin/user/new";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
	    us.save(user);
	     
	    return "redirect:/user";
	}
	
	@RequestMapping("/editUser/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("admin/user/edit_user");
	    User user = us.get(id);
	    mav.addObject("user", user);
	     
	    return mav;
	}
	
	
	@RequestMapping(value = "/Updatepass/{id}")
	public String resetUser(@PathVariable(name = "id") int id) {
		User user = us.get(id);
		String encodepass = passwordEncoder().encode("555");
		user.setPassword(encodepass);
	    us.save(user);
	    return "redirect:/user";
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteProduct(HttpSession session,@PathVariable(name = "id") int id) {
		User user = (User) session.getAttribute("user");
		if(user.getId()!=id)
	    us.delete(id);
	    return "redirect:/user";       
	}
	
	
}
