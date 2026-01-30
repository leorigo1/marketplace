package leonardorigo.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardorigo.marketplace.entities.ProductEntity;
import leonardorigo.marketplace.services.ProductService;

@RestController(value = "/product")
@CrossOrigin(origins = "localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<ProductEntity> createProduct (@PathVariable ProductEntity product) {
		productService.createProduct(product);
		return ResponseEntity.ok().build();
	}
}
