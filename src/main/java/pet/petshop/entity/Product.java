package pet.petshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "cate")
    private Integer cate;
	
	@Column(name = "name")
	//@Pattern(regexp="^[a-zA-Z0-9\s]*$", message = "Không chứa kí tự đặc biệt")
	@Size(min = 3, max = 30, message = "Ít nhất 3 kí tự, nhiều nhất 30 kí tự")
	@NotBlank(message = "Hãy nhập tên sản phẩm")
    private String name;
	
	@Column(name = "brand")
	//@Pattern(regexp="^[a-zA-Z0-9\s]*$", message = "Không chứa kí tự đặc biệt")
	@Size(min = 3, max = 30, message = "Ít nhất 3 kí tự, nhiều nhất 30 kí tự")
	@NotBlank(message = "Hãy nhập hãng của sản phẩm")
    private String brand;
	
	@Column(name="images")

    private String images;
	
	@Column(name = "status")
    private Boolean status;
	
	@Column(name = "price")
	@NotNull(message = "Hãy nhập giá")
    private Integer price;
	
	@Column(name = "discount")
    private Integer discount;

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCate() {
        return cate;
    }

    public void setCate(Integer cate) {
        this.cate = cate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
