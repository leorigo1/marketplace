package leonardorigo.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardorigo.marketplace.entities.ProductEntity;
import leonardorigo.marketplace.services.ProductService;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<ProductEntity> createProduct (@PathVariable ProductEntity product) {
		productService.createProduct(product);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list-all")
	public List<ProductEntity> listAll() {
		return productService.listAllProducts();
	}
}
