package leonardorigo.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardorigo.marketplace.DTOS.RegisterDTO;
import leonardorigo.marketplace.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody RegisterDTO data) {
		userService.RegisterUser(data);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
