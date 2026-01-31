package leonardorigo.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardorigo.marketplace.DTOS.CreateProductDTO;
import leonardorigo.marketplace.entities.ProductEntity;
import leonardorigo.marketplace.services.ApiResponse;
import leonardorigo.marketplace.services.ProductService;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<ApiResponse> createProduct (@RequestBody CreateProductDTO product,
													  @PathVariable Long userId) {
		
		productService.createProduct(product,userId);
		return ResponseEntity
			   .status(HttpStatus.CREATED)
			   .body(new ApiResponse("Produto Criado com sucesso!"));
	}
	
	@GetMapping("/list-all")
	public ResponseEntity<List<ProductEntity>> listAll() {
	    return ResponseEntity.ok(productService.listAllProducts());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteProduct (@PathVariable String id) {
		productService.deleteProductbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Produto deletado com sucesso!"));
	}
	
	@GetMapping("/find/{id}")
	ResponseEntity<Optional<ProductEntity>> viewProduct (@PathVariable String id) {
		return ResponseEntity.ok(productService.viewProduct(id));
	}
}
