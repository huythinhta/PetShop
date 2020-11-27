package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pet.petshop.service.ProductService;

@Controller
@RequestMapping("/sanpham")
public class indexController {
	@Autowired
	private ProductService ps;

	@RequestMapping(method= RequestMethod.GET)
	public String index(ModelMap model) {
		model.put("product",ps.listAll());
		return "product/sanpham";
	}
	
	
	
	
	
	
	
}
