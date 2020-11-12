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

import pet.petshop.entity.Blog;
import pet.petshop.entity.Productdetail;


import pet.petshop.service.ProductDetailService;

@Controller
public class ProductDetailController {
	@Autowired
	private ProductDetailService pds;
	@RequestMapping("/productdetail")
	public String viewHomePage(Model model) {
		List<Productdetail> listdetail=pds.listALL();
		model.addAttribute("listdetail",listdetail);
		return "product/index";
	}
	
	@RequestMapping("/addproductdetail")
	public String showNewProductDetail(Model model) {
		Productdetail productdetail = new Productdetail();
		model.addAttribute("productdetail",productdetail);
		return "product/productdetail_add";
	}
	
	@RequestMapping(value = "/saveproductdetail",method = RequestMethod.POST)
	public String saveProductDetail(@ModelAttribute("productdetail")Productdetail productdetail) {
		pds.save(productdetail);
		return "redirect:/productdetail";
	}
	
	@RequestMapping("/editproductdetail/{id}")
	public ModelAndView showEditBlog(@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("product/productdetail_edit");
		Productdetail productdetail = pds.get(id);
		mav.addObject("productdetail", productdetail);
		return mav;
	}
	
	@RequestMapping("/deleteproductdetail/{id}")
	public String deleteProductDetail(@PathVariable(name = "id")Integer id) {
		pds.delete(id);
		return "redirect:/productdetail";
	}
}
