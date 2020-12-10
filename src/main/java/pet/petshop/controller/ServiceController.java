package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Services;
import pet.petshop.service.ServiceServices;
import pet.petshop.utils.FileUploadUtil;

@Controller
public class ServiceController {
	@Autowired
	private ServiceServices abc;

	@RequestMapping("/services")
	public String viewHomePage(Model model) {
		List<Services> listServices = abc.listALl();
		model.addAttribute("listServices", listServices);
		return "admin/service/index1";
	}

	public String viewHomePage(Model model,
			@RequestParam(value = "search", required = false, defaultValue = "") String search) {
		List<Services> listServices = null;
		if (search.isEmpty()) {
			listServices = abc.listALl();
		} else {
			listServices = abc.name(search);
		}
		model.addAttribute("listServices", listServices);
		return "admin/service/index1";
	}

	@RequestMapping("/newservices")
	public String showNewServiceForm(Model model) {
		Services services = new Services();
		model.addAttribute("services", services);
		return "admin/service/new_service1";
	}



	@RequestMapping(value = "/saveservice", method = RequestMethod.POST)
	public String saveService(@ModelAttribute("services") @Valid Services services,
							  @RequestParam("image") MultipartFile multipartFile,
							  BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors() == true) {
			return "service/new_service1";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		services.setImages(fileName);
		Services saveServices = abc.save(services);
		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/img/";

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		System.out.println(uploadDir);
		return "redirect:/services";
	}

	@RequestMapping("/editservice/{id}")
	public ModelAndView showEditServiceForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("admin/service/edit_services1");
		Services services = abc.get(id);
		mav.addObject("services", services);

		return mav;
	}

	@RequestMapping("/deleteservice/{id}")
	public String delteteServices(@PathVariable(name = "id") Integer id) {
		abc.delete(id);
		return "redirect:/services";
	}
}
