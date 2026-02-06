package leonardorigo.marketplace.DTOS;

import leonardorigo.marketplace.enums.UserRoles;

public class RegisterDTO {

	private String email;
	private String password;
	private UserRoles role;
	
	public RegisterDTO() {}

	public RegisterDTO(String email, String password, UserRoles role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
