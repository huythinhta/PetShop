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
import pet.petshop.entity.Services;
import pet.petshop.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	private BlogService bs;
	@RequestMapping("/blog")
	public String viewHomePage(Model model) {
		List<Blog> listblog=bs.listALL();
		model.addAttribute("listblog",listblog);
		return "blog/index";
	}
	
	@RequestMapping("/newblog")
	public String showNewBlogForm(Model model) {
		Blog blog = new Blog();
		model.addAttribute("blog",blog);
		return "blog/newblog";
	}
	
	@RequestMapping(value = "/saveblog",method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog")Blog blog) {
		bs.save(blog);
		return "redirect:/blog";
	}
	
	@RequestMapping("/editblog/{id}")
	public ModelAndView showEditBlog(@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("blog/editblog");
		Blog blog = bs.get(id);
		mav.addObject("blog", blog);
		return mav;
	}
	
	@RequestMapping("/deleteblog/{id}")
	public String deleteBlog(@PathVariable(name = "id")Integer id) {
		bs.delete(id);
		return "redirect:/blog";
	}
}
