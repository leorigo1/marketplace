package leonardorigo.marketplace.DTOS;

public class UserResponseDTO {

    private Long userId;
    private String name;
    private String email;
	
	public UserResponseDTO() {}

	public UserResponseDTO(Long userId, String name, String email) {
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
