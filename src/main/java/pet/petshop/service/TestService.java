package pet.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.dto.ProductDto;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;
import pet.petshop.entity.Productdetail;

@Service
public class TestService {
	@Autowired
	private ProductService ps;

	@Autowired
	private ProductDetailService pds;

	@Autowired
	private ProductCategoryService pcs;

//	 public ProductDto(Integer id, String name, String brand, String images, String status, Integer price, Integer discount,
//				Integer category, Integer height, Integer width, Integer length, String typeOfPet, String stage,
//				String description)

//	public void Test(int id) {
//		Product product = ps.get(id);
//		Productdetail productdetail = pds.get(id);
//		Productcategories productcate = pcs.get(id);
//		ProductDto pdto = new ProductDto(product.getId(),product.getName(),product.getBrand(),product.getImages(),
//				product.getStatus(),product.getPrice(),product.getDiscount(),product.getCate(),productdetail.getHeight(),
//				productdetail.getWidth(),productdetail.getLength(),productdetail.getTypeofpet(),productdetail.getStage(),
//				productdetail.getDescription());
//	}

	

}
