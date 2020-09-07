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
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

}
