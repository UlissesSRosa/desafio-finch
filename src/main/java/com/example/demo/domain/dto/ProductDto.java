package com.example.demo.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = -8883468374085237642L;

	private String name;
	private String type;
	private Double price;
	private String img;

	public ProductDto(String name, String type, Double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ProductDto() {
		// TODO Auto-generated constructor stub
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

	public void setPrice(Double preco) {
		this.price = preco;
	}
}
