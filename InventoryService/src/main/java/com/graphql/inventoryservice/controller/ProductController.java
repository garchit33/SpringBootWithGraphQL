package com.graphql.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.inventoryservice.entity.Product;
import com.graphql.inventoryservice.record.ProductInput;
import com.graphql.inventoryservice.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@QueryMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@QueryMapping
	public List<Product> getProductByCategory(@Argument String category) {
		return productService.getProductByCategory(category);
	}

	@MutationMapping
	public Product updateStock(@Argument int id, @Argument int quantity) {
		return productService.updateStock(id, quantity);
	}

	@MutationMapping
	public Product receiveShipment(@Argument int id, @Argument int quantity) {
		return productService.receiveShipment(id, quantity);
	}

	@MutationMapping
	public Product createProduct(@Argument ProductInput productInput) {
		return productService.createProduct(productInput);
	}
}
