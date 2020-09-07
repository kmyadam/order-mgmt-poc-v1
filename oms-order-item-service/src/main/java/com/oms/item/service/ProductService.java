package com.oms.item.service;

import com.oms.item.entity.Product;

import java.util.List;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	Product saveOrUpdateProduct(Product product);
}
