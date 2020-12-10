package pet.petshop.entity;


import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "productcategories")
public class Productcategories {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "productcategories",cascade = CascadeType.ALL)
	private Collection<Product> product;
    
    public Productcategories() {
        super();
        // TODO Auto-generated constructor stub
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

}
