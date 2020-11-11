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

import pet.petshop.entity.Blogcategories;
import pet.petshop.entity.Servicecategories;
import pet.petshop.service.BlogCategoriesService;

@Controller
public class BlogCategoriesController {
	@Autowired
	private BlogCategoriesService bcpo;
	
	@RequestMapping("/blogcategories")
	public String viewHomePage(Model model) {
		List<Blogcategories> blogcategories= bcpo.listALL();
		model.addAttribute("blogcategories",blogcategories);
		return "blog/blogcategories";
	}
	
	@RequestMapping("/newblogcategories")
	public String newBlogCategoriesForm(Model model) {
		Blogcategories blogcategories = new Blogcategories();
		model.addAttribute("blogcategories",blogcategories);
		return "blog/newblogcategories";
	}
	
	@RequestMapping(value = "/saveblogcategories",method = RequestMethod.POST)
	public String saveBlogCategories(@ModelAttribute("blogcategories")Blogcategories blogcategories) {
		bcpo.save(blogcategories);
		return "redirect:/blogcategories";
	}
	
	@RequestMapping("/editblogcategories/{id}")
	public ModelAndView showEditBlogCategories(@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("blog/editblogcategories");
		Blogcategories blogcategories= bcpo.get(id);
		mav.addObject("blogcategories", blogcategories);
		return mav;
	}
	@RequestMapping("/deleteblogcategories/{id}")
	public String deleteBlogCategories(@PathVariable(name = "id")Integer id) {
		bcpo.delete(id);
		return "redirect:/blogcategories";
	}
	
}
