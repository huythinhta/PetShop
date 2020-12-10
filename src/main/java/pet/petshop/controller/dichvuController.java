package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Services;
import pet.petshop.service.ServiceServices;

@Controller
public class dichvuController {

	@Autowired
	private ServiceServices ss;
	
	@RequestMapping("/dichvu/{id}")
    public ModelAndView xemsanpham(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("service/thongtindichvu");
        Services service  = ss.get(id);
       
        mav.addObject("service", service);
       

        return mav;
    }
}
