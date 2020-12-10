package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import pet.petshop.entity.Blog;
import pet.petshop.entity.Blogcategories;
import pet.petshop.entity.Services;
import pet.petshop.service.BlogCategoriesService;
import pet.petshop.service.BlogService;
import pet.petshop.utils.FileUploadUtil;

@Controller

public class BlogController {
	@Autowired
	private BlogService bs;
	
	@Autowired
	private BlogCategoriesService bcs;
	
	@RequestMapping("/blogindex")
	public String viewHomePage(Model model) {
		List<Blog> listblog=bs.listALL();
		model.addAttribute("listblog",listblog);
		return "admin/blog/blog_index";
	}
	
	@RequestMapping("/newblog")
	public String showNewBlogForm(Model model) {
		Blog blog = new Blog();
		
		model.addAttribute("blog",blog);
		
		List<Blogcategories> cate = bcs.listALL();
		model.addAttribute("cate", cate);
		return "admin/blog/blog_add";
	}
	
	
	
	@RequestMapping(value = "/saveblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") Blog blog, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		blog.setImages(fileName);
		Blog saveBlog = bs.save(blog);
		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/img/";

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		System.out.println(uploadDir);
		return "redirect:/blogindex";
	}
	
	@RequestMapping("/editblog/{id}")
	public ModelAndView showEditBlog(Model model,@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("admin/blog/blog_edit");
		List<Blogcategories> cate = bcs.listALL();
		model.addAttribute("cate", cate);
		Blog blog = bs.get(id);
		mav.addObject("blog", blog);
		return mav;
	}
	
	@RequestMapping("/deleteblog/{id}")
	public String deleteBlog(@PathVariable(name = "id")Integer id) {
		bs.delete(id);
		return "redirect:/blogindex";
	}
}
