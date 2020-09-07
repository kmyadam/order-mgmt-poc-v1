package com.oms.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oms.model.Product;

@FeignClient("OMS-ORDER-ITEM-SERVICE")
@RequestMapping(value="/product", produces = {"application/json"})
public interface ProductControllerProxy {

	@GetMapping()
	List<Product> getAllProducts();
	
	@GetMapping(path={"/{id}"})
	Product getProductById(@PathVariable("id") Long id);
	
	@PostMapping(consumes = {"application/json"})
	Product saveProduct(@RequestBody Product product);
}
