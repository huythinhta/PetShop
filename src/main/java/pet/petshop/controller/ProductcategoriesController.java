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

import pet.petshop.entity.Productcategories;
import pet.petshop.service.ProductCategoryService;

@Controller
public class ProductcategoriesController {
	@Autowired
	private ProductCategoryService pds;
	
	@RequestMapping("/productcategories")
	public String viewHomePage(Model model) {
		List<Productcategories> productcategories= pds.listALL();
		model.addAttribute("productcategories",productcategories);
		return "product/productcategories";
	} 
	
	@RequestMapping("/newproductcategories")
	public String newproductcategories(Model model) {
		Productcategories Productcategories= new Productcategories();
		model.addAttribute("Productcategories",Productcategories);
		return "product/newproductcategories";
	}
	
	@RequestMapping(value = "/saveproductcategories", method = RequestMethod.POST)
	public String saveproductcategories(@ModelAttribute("productcategories")Productcategories productcategories) {
		pds.save(productcategories);
		return "redirect:/productcategories";
	}
	
	@RequestMapping("/editproductcategories/{id}")
	public ModelAndView showEditproductcategories(@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("product/editproductcategories");
		Productcategories productcategories = pds.get(id);
		mav.addObject("productcategories",productcategories);
		
		return mav;
	}
	
	@RequestMapping("/deleteproductcategories/{id}")
	public String deleteproductcategories(@PathVariable(name = "id")Integer id)
{
		pds.delete(id);
		return "redirect:/productcategories";
		}
}
