package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Product;
import pet.petshop.repository.ProductResopository2;
import pet.petshop.repository.ProductRespository;


@Service
public class ProductService {
    @Autowired
    private ProductRespository pr;
    @Autowired
    private ProductResopository2 pr1;
    public List<Product> listAll() {
        return pr1.findAll();
    }
    public Page<Product> listAllPage(int pageNumber) {
    	Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return pr.findAll(pageable);
    }
    
    public Page<Product> listAllPageAdminProduct(int pageNumber, String sortField, String sortDir) {
    	Sort sort = Sort.by(sortField);
    	sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return pr.findAll(pageable);
    }
    public List<Product> searchByName(String search) {
        return pr1.getProductsByNameContains(search);
    }

    public Product save(Product product) {
       return pr1.save(product);
    }

    public Product get(Integer id) {
        return pr1.findById(id).get();
    }

    public void delete(Integer id) {
        pr1.deleteById(id);
    }
}
