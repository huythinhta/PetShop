package pet.petshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productdetail {
	private Integer idproduct;
	private Integer height;
	private Integer width;
	private Integer length;
	private String typeofpet;
	private String stage;
	private String description;
	
	
	public Productdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(Integer idproduct) {
		this.idproduct = idproduct;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getTypeofpet() {
		return typeofpet;
	}
	public void setTypeofpet(String typeofpet) {
		this.typeofpet = typeofpet;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
