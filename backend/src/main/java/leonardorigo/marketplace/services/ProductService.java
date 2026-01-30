package leonardorigo.marketplace.services;

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
	
	
}
