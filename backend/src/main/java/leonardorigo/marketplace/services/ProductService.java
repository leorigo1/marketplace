package leonardorigo.marketplace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardorigo.marketplace.DTOS.CreateProductDTO;
import leonardorigo.marketplace.entities.ProductEntity;
import leonardorigo.marketplace.entities.UserEntity;
import leonardorigo.marketplace.repositories.ProductRepository;
import leonardorigo.marketplace.repositories.UserRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void createProduct (CreateProductDTO dto, Long id) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
        ProductEntity product = new ProductEntity();
        product.setName(dto.getProductName());
        product.setDescription(dto.getProductDescription());
		product.setPrice(dto.getProductPrice());
		product.setUser(user);
		 productRepository.save(product);
	}
	
	public List<ProductEntity> listAllProducts () {
		return productRepository.findAll();
	}

	public void deleteProductbyId (String id) {
		productRepository.deleteById(id);
	}
	
	public Optional<ProductEntity> viewProduct (String id) {
		return productRepository.findById(id);
	}
	
}
