package com.example.demo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "shoppingCart")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Product> products = new HashSet<>();
	private Integer quantity;
	private Double total;
	
	public ShoppingCart() {
		
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
	public Double getTotal() {
		if(total == null) {
			return (double) 0;
		}
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void addProduct(Product product) {
		products.add(product);
	}
}