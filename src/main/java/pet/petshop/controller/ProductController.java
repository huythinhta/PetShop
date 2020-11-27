package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Product;
import pet.petshop.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService ps;
    
    @RequestMapping("/trangchu")
    public String index2(ModelMap model) {
		model.put("product",ps.listAll());
		return "index4";
	}

    @RequestMapping("/product")
    public String viewHomePage(Model model, @RequestParam(value = "search", defaultValue = "", required = false) String search) {
        List<Product> product = null;
        if (search.isEmpty()) {
            product = ps.listAll();
        } else {
            product = ps.searchByName(search);
        }
        model.addAttribute("product", product);
        return "product/index_product";
    }

    @RequestMapping("/newproduct")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/product_add";
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        ps.save(product);
        return "redirect:/product";
    }

    @RequestMapping("/editproduct/{id}")
    public ModelAndView showEditProduct(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("product/product_edit");
        Product product = ps.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        ps.delete(id);
        return "redirect:/product";
    }
}

