package pet.petshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String name;
	
	private String phone;
	
	private String address;
	
	private String avatar;
	
	
	
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

	public User() {
		
	}
	

	public User(int id,
			@Email(message = "Địa chỉ không hợp lệ") @Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng") @NotBlank(message = "Vui lòng nhập Email") String email,
			@NotBlank(message = "Vui lòng nhập password") @Pattern(regexp = "^\\s*\\S+\\s*$", message = "Không được để khoảng trắng") String password,
			String role, String name, String phone, String address, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.avatar = avatar;
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
	
	
}