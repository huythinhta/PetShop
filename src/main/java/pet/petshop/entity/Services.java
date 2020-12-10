package pet.petshop.entity;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "services")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Pattern(regexp="^[a-zÁ-Z0-9\s]*$", message = "Không chứa kí tự đặc biệt")
	@Size(min = 3, max = 30, message = "Ít nhất 3 kí tự, nhiều nhất 11 kí tự")
	@NotBlank(message = "Hãy nhập tên sản phẩm")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "Hãy nhập giá")
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "status")
	private boolean status;
	
	@NotBlank(message = "Hãy nhập thông tin")
	@Column(name = "description")
	private String description;
	
	@Column(name = "discount")
	private Integer discount;
	
	@ManyToOne
	@JoinColumn(name = "cate" )
	private Servicecategories cate;

	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Collection<Schedule> schedule;
	
	public Services() {
		super();
	}

	public Services(Integer id,
			@Size(min = 3, max = 30, message = "Ít nhất 3 kí tự, nhiều nhất 11 kí tự") @NotBlank(message = "Hãy nhập tên sản phẩm") String name,
			@NotNull(message = "Hãy nhập giá") Integer price, String images, boolean status,
			@NotBlank(message = "Hãy nhập thông tin") String description, Integer discount, Servicecategories cate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.images = images;
		this.status = status;
		this.description = description;
		this.discount = discount;
		this.cate = cate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Servicecategories getCate() {
		return cate;
	}

	public void setCate(Servicecategories cate) {
		this.cate = cate;
	}
	
	
}

