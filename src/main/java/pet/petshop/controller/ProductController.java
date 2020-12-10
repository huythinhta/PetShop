package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;
import pet.petshop.service.ProductCategoryService;
import pet.petshop.service.ProductService;
import pet.petshop.utils.FileUploadUtil;

@Controller
public class ProductController {
    @Autowired
    private ProductService ps;

    @Autowired
    private ProductCategoryService pdc;


    @RequestMapping("/test")
    public String index111(ModelMap model) {
        model.put("product", ps.listAll());
        return "index6";
    }

    @RequestMapping("/product")
    public String viewHomePage(Model model,
                               @RequestParam(value = "search", defaultValue = "", required = false) String search,
                               @RequestParam(value = "category", defaultValue = "", required = false) String category,
                               @RequestParam(value = "status", defaultValue = "", required = false) String status
    ) {
        List<Product> product = null;

        if (!category.isEmpty() || !status.isEmpty()) {
            product = ps.getListProductByFilter(
                    search,
                    !category.isEmpty() ? Integer.parseInt(category) : -1,
                    status.equals("1")
            );
        } else {
            product = ps.searchByName(search);
        }

        model.addAttribute("catelogiesFilter", pdc.listALL());
        model.addAttribute("product", product);
        model.addAttribute("search", search);
        model.addAttribute("category", category);
        model.addAttribute("status", status);

        return "admin/product/index_product";
    }

    @RequestMapping("/newproduct")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/product_add";
    }


    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    public String saveProduct(
            @ModelAttribute("product") @Valid Product product,
            @RequestParam("image") MultipartFile multipartFile,
            BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors() == true) {
            return "product/product_add";
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setImages(fileName);
        Product saveProduct = ps.save(product);
        String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/img/";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        System.out.println(uploadDir);
        return "redirect:/product";
    }

    @RequestMapping("/editproduct/{id}")
    public ModelAndView showEditProduct(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("admin/product/product_edit");
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

