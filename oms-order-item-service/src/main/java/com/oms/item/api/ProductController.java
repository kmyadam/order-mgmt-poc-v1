package com.oms.item.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oms.exception.NotFoundException;
import com.oms.item.entity.Product;
import com.oms.item.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/product" , tags = {"Product Controller"})
@RestController
@RequestMapping(value="/product", produces = {"application/json"})
public class ProductController {
	
	@Autowired
	ProductService productService;

	@ApiOperation(value = "List of all Products", response = ArrayList.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@GetMapping()
	ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@ApiOperation(value = "Get Product Details", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@GetMapping(path={"/{id}"})
	ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getProductById(id);
		if(!product.isPresent()) {
			throw new NotFoundException("Product not found for id: " + id);
		}
		return ResponseEntity.ok().body(product.get());
	}
	
	@ApiOperation(value = "Save Product Details", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Created"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@PostMapping(consumes = {"application/json"})
	ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		Product savedProduct = productService.saveProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).body(savedProduct);
	}
	
	@ApiOperation(value = "Update Product Details", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@PutMapping(path={"/{id}"}, consumes = {"application/json"})
	ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable("id") Long id) {
		Optional<Product> dbProduct = productService.getProductById(id);
		if(!dbProduct.isPresent()) {
			throw new NotFoundException("Product not found for id: " + id);
		}
		return ResponseEntity.ok().body(productService.updateProduct(product, id));
	}
}
