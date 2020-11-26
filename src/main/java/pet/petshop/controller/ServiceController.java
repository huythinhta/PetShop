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

import pet.petshop.entity.Services;
import pet.petshop.service.ServiceServices;

@Controller
public class ServiceController {
	@Autowired
	private ServiceServices abc;
	@RequestMapping("/dichvu")
	public String viewHomePageDichvu(Model model) {
		List<Services> listServices = abc.listALl();
		model.addAttribute("listServices",listServices);
		return "service/show_dichvu";
	}
	@RequestMapping("/services")
	public String viewHomePage(Model model) {
		List<Services> listServices = abc.listALl();
		model.addAttribute("listServices",listServices);
		return "service/index1";
	}
	
	@RequestMapping("/newservices")
	public String showNewServiceForm(Model model) {
		Services services = new Services();
		model.addAttribute("services",services);
		return "service/new_service1";
	}
	
	@RequestMapping(value="/saveservice", method = RequestMethod.POST)
		public String saveService(@ModelAttribute("services") Services services)
		{
		abc.save(services);
		return "redirect:/services";
}
	@RequestMapping("/editservice/{id}")
	public ModelAndView showEditServiceForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("service/edit_services1");
		Services services= abc.get(id);
		mav.addObject("services",services);
		
		return mav;
	}
	
	@RequestMapping("/deleteservice/{id}")
	public String delteteServices(@PathVariable(name="id") Integer id) {
		abc.delete(id);
		return "redirect:/services";
	}
}
