package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -8883468374085237642L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private Double price;
	private String img;
	
	
	
	 @JsonIgnore	 
	 @ManyToOne	  
	 @JoinColumn(name = "shoppingcart")
	 private ShoppingCart shoppingCart;
	 

	public Product(String name, String type, Double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Product() {
		
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getType() {
		return type;
	}

	public void setType(String tipo) {
		this.type = tipo;
	}

	public Double getPrice() {
		return price;
	}
	
	public void setCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public void setPrice(Double preco) {
		this.price = preco;
	}	
}
