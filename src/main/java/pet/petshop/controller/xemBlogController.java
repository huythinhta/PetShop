package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Blog;
import pet.petshop.entity.User;
import pet.petshop.service.BlogService;
import pet.petshop.service.UsersService;

@Controller
public class xemBlogController {
	
	@Autowired
	private BlogService bs;
	
	private UsersService us;
	
	@RequestMapping("/blog/{id}")
    public ModelAndView xemsanpham(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("blog/thongtinblog");
        Blog blog= bs.get(id);
        mav.addObject("blog", blog);
        return mav;
    }
	
	

}
