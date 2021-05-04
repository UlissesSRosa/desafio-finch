package com.example.demo.domain.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.domain.Product;

public class ShoppingCartDto {

	private Long id;
	private Set<Product> products = new HashSet<>();
	private Integer quantity;
	private BigDecimal total;

	public ShoppingCartDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

}
