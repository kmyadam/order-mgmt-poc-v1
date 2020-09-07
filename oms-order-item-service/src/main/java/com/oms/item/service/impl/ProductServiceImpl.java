package com.oms.item.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.item.entity.Product;
import com.oms.item.repository.ProductRepository;
import com.oms.item.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product saveProduct(Product product) {
		if(null != product) {
			product.setId(null);
			return productRepository.save(product);
		}
		return product;
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		if(null != product) {
			product.setId(id);
			return productRepository.save(product);
		}
		return product;
	}

}
