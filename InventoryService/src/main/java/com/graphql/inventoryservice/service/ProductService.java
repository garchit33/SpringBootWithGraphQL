package com.graphql.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.inventoryservice.entity.Product;
import com.graphql.inventoryservice.record.ProductInput;
import com.graphql.inventoryservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProductByCategory(String category) {
		return productRepository.getByCategory(category);
	}

	public Product updateStock(int id, int quantity) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No Product found with ID: " + id));
		existingProduct.setStock(quantity);
		return productRepository.save(existingProduct);
	}

	public Product receiveShipment(int id, int quantity) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No Product found with ID: " + id));
		existingProduct.setStock(quantity + existingProduct.getStock());
		return productRepository.save(existingProduct);
	}

	public Product createProduct(ProductInput productInput) {
		Product product = new Product(productInput.name(), productInput.category(), productInput.price(),
				productInput.stock());
		return productRepository.save(product);
	}
}
