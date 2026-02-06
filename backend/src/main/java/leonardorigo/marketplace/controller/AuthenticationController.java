package leonardorigo.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import leonardorigo.marketplace.DTOS.AuthenticationDTO;
import leonardorigo.marketplace.DTOS.RegisterDTO;
import leonardorigo.marketplace.entities.UserEntity;
import leonardorigo.marketplace.repositories.UserRepository;
import leonardorigo.marketplace.services.ApiResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public AuthenticationController(
	        UserRepository userRepository,
	        PasswordEncoder passwordEncoder
	) {
	    this.userRepository = userRepository;
	    this.passwordEncoder = passwordEncoder;
	}

	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody @Valid AuthenticationDTO dto) {
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().body(new ApiResponse("usuario logado com sucesso"));
	}
	
	@PostMapping("/register") 
	public ResponseEntity register(@RequestBody @Valid RegisterDTO dto) {
		if (this.userRepository.findByEmail(dto.getEmail()) != null) return ResponseEntity.ok().build();
		
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
		UserEntity user = new UserEntity(dto.getEmail(),encryptedPassword,dto.getRole());
		
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
}
