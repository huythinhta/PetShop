package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.Servicecategories;
import pet.petshop.service.servicecategoriesService;

@Controller
public class servicecategoriesController {
	@Autowired
	private servicecategoriesService sepo;
	
	@RequestMapping("/servicecategories")
	public String viewHomePage(Model model)
	{
		List<Servicecategories> listservicecategories = sepo.listAll();
		model.addAttribute("listservicecategories",listservicecategories);
		return ("cateservice/index");
	}
	
	@RequestMapping("/newservicecategories")
	public String showNewServiceCategoriesForm(Model model) {
		Servicecategories servicecategories = new Servicecategories();
		model.addAttribute("servicecategories",servicecategories);
		return "cateservice/new_servicecategories";
	}
	
	@RequestMapping(value = "/saveservicecate", method = RequestMethod.POST)
		public String saveCategories(@ModelAttribute("servicecategories")Servicecategories servicecategories)
		{
			sepo.save(servicecategories);
			return ("redirect:/servicecategories");
		}
}
