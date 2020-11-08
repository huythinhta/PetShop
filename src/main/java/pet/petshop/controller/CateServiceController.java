package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.petshop.service.CateServiceServices;

@Controller
public class CateServiceController {
	@Autowired
	private CateServiceServices dao;
	
	@RequestMapping("/categoryservice")
	public String viewHomePage()
	{
		return "cateservice/index";
	}
}
