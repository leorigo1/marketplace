package leonardorigo.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardorigo.marketplace.DTOS.RegisterDTO;
import leonardorigo.marketplace.entities.UserEntity;
import leonardorigo.marketplace.services.ApiResponse;
import leonardorigo.marketplace.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/list-all")
	public ResponseEntity<List<UserEntity>> listUsers() {
		return ResponseEntity.ok().body(userService.listAllUsers());
	}
}
