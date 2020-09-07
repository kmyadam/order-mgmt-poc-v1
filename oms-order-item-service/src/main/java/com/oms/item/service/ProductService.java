package com.oms.item.service;

import java.util.List;
import java.util.Optional;

import com.oms.item.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Optional<Product> getProductById(Long id);
	
	Product saveProduct(Product product);
	
	Product updateProduct(Product product, Long id);
}
