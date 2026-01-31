package leonardorigo.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardorigo.marketplace.DTOS.RegisterDTO;
import leonardorigo.marketplace.entities.UserEntity;
import leonardorigo.marketplace.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void RegisterUser(RegisterDTO data) {
		UserEntity user = new UserEntity();
		user.setEmail(data.getEmail());
		user.setName(data.getName());
		user.setPassword(data.getPassword());
		userRepository.save(user);
	}
}
