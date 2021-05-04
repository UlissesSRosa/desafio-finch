package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Product;
import com.example.demo.domain.dto.ProductDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product find(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException("Produto Não Encontrado!!!"));
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product fromDto(ProductDto productDto) {
		return new Product(productDto.getName(), productDto.getType(), productDto.getPrice());
	}
}
