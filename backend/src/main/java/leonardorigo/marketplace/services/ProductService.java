package leonardorigo.marketplace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardorigo.marketplace.DTOS.CreateProductDTO;
import leonardorigo.marketplace.DTOS.ProductResponseDTO;
import leonardorigo.marketplace.DTOS.UserResponseDTO;
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
	
	public void createProduct (CreateProductDTO productDTO, Long id) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
        ProductEntity product = new ProductEntity();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		
		product.setUser(user);
		
		 productRepository.save(product);
	}
	
	public List<ProductResponseDTO> listAllProducts () {
		return productRepository.findAll().stream().map(product -> {

	        UserEntity user = product.getUser();
	        UserResponseDTO userDTO = new UserResponseDTO(
	            user.getId(),
	            user.getName(),
	            user.getEmail()
	        );

	        return new ProductResponseDTO(
	            product.getId(),
	            product.getName(),
	            product.getDescription(),
	            product.getPrice(),
	            userDTO
	        );
	    }).toList();
	}

	public void deleteProductbyId (String id) {
		productRepository.deleteById(id);
	}
	
	public Optional<ProductEntity> viewProduct (String id) {
		return productRepository.findById(id);
	}
}
