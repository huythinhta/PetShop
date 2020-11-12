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

import pet.petshop.entity.Product;
import pet.petshop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@RequestMapping("/product")
	public String viewHomePage(Model model) {
		List<Product> product = ps.listAll();
		model.addAttribute("product", product);
		return "product/product";
	}
	
	@RequestMapping("/newproduct")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "product/newproduct";
	}
	
	@RequestMapping(value = "/saveproduct",method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product")Product product) {
		ps.save(product);
		return "redirect:/product";
	}
	
	@RequestMapping("/editproduct/{id}")
	public ModelAndView showEditProduct(@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("product/editproduct");
		Product product = ps.get(id);
		mav.addObject("product",product);
		
		return mav;
	}
	
	@RequestMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable(name = "id")Integer id) {
		ps.delete(id);
		return "redirect:/product";
	}
}
