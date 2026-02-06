package leonardorigo.marketplace.enums;

public enum UserRoles {

	ADMIN("ADMIN"),
	TEC("TEC"),
	USER("USER");
	
	private String role;
	
	UserRoles(String role) {
	this.role = role;
	}

	public String getRole() {
		return role;
	}
}
