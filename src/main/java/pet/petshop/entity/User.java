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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	@Email(message = "Địa chỉ không hợp lệ")
	@Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng")
	@NotBlank(message = "Vui lòng nhập Email")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "Vui lòng nhập password")
	@Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng")
	
	private String password;
	@Column(name = "role")
	private String role;
	
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "avatar")
	private String avatar;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Collection<Bill> bill;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	


	public User(
			@Email(message = "Địa chỉ không hợp lệ") @Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng") @NotBlank(message = "Vui lòng nhập Email") String email,
			@NotBlank(message = "Vui lòng nhập password") @Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng") String password,
			String role, String name, String phone, String address) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Collection<Bill> getBill() {
		return bill;
	}

	public void setBill(Collection<Bill> bill) {
		this.bill = bill;
	}
	
	
	
	
}