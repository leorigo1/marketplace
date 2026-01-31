package leonardorigo.marketplace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardorigo.marketplace.entities.ProductEntity;
import leonardorigo.marketplace.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductEntity createProduct (ProductEntity product) {
		return productRepository.save(product);
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
