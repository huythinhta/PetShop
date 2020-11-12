package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.User;
import pet.petshop.service.UsersService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UsersService us;
	
	@RequestMapping("/user")
	public String index(Model model) {
		List<User> list = us.listAll();
		model.addAttribute("users",list);
		return "user/index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	     
	    return "user/new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user) {
	    us.save(user);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_user");
	    User user = us.get(id);
	    mav.addObject("user", user);
	     
	    return mav;
	}
}
