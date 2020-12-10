package pet.petshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billinfo")
public class BillInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idbill" )
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "idproduct" )
	private Product product;
	
	
	@Column(name = "countitem")
	private int countItem;
	
	public BillInfo() {
		// TODO Auto-generated constructor stub
	}
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCountItem() {
		return countItem;
	}

	public void setCountItem(int countItem) {
		this.countItem = countItem;
	}

	
	
	
}
