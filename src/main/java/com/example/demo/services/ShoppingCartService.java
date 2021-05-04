package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.domain.ShoppingCart;
import com.example.demo.domain.dto.ProductDto;
import com.example.demo.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart findCart(Long id) {		
		try {
			ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();		
			return shoppingCart;			
		} catch (Exception e) {
			return new ShoppingCart();
		}
	}
	
	public ShoppingCart add(Product product, ShoppingCart shoppingCart) {
		shoppingCart.addProduct(product);
		return shoppingCartRepository.save(shoppingCart);
	}	
}