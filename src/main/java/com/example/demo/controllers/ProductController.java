package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.domain.Product;
import com.example.demo.domain.ShoppingCart;
import com.example.demo.domain.dto.ProductDto;
import com.example.demo.services.ProductService;
import com.example.demo.services.ShoppingCartService;

@Controller
@RequestMapping(value = "products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String viewProducts(Model model) {
		Long shoppingCartId = (long) 1;
		model.addAttribute("products", productService.findAll());
		model.addAttribute("productDTO", new ProductDto());
		model.addAttribute("shoppingCart", shoppingCartService.findCart(shoppingCartId).getProducts());
		return "products";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product product(@PathVariable Long id) {
		return productService.find(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveProducts(Model model, @ModelAttribute ProductDto productObj) {
		Product product = productService.fromDto(productObj);
		productService.save(product);		
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/addToCart/{idshoppingCart}/{idproduct}", method = RequestMethod.POST)
	public String addToCart(@PathVariable Long idshoppingCart, @PathVariable Long idproduct, Model model, @ModelAttribute ProductDto productObj) {		
		Product product = productService.find(idproduct);
		ShoppingCart shoppingCart = shoppingCartService.findCart(idshoppingCart);
		product.setCart(shoppingCart);
		shoppingCart.setQuantity(1);
		Double total = shoppingCart.getTotal() + product.getPrice();
		shoppingCart.setTotal(total);
		shoppingCartService.add(product, shoppingCart);	
		return "redirect:/products";
	}
	
	
}