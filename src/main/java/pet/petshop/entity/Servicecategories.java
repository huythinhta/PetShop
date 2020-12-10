package pet.petshop.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servicecategories")
public class Servicecategories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "cate", cascade = CascadeType.ALL)
	private Collection<Services> services;

	
	
	public Servicecategories() {
		super();
	}



	public Servicecategories(Integer id, String name, Collection<Services> services) {
		super();
		this.id = id;
		this.name = name;
		this.services = services;
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



	public Collection<Services> getServices() {
		return services;
	}



	public void setServices(Collection<Services> services) {
		this.services = services;
	}

	

}
