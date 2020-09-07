package com.oms.item.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.item.entity.Product;
import com.oms.item.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ProductController" , tags = {"Product Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Product Controller", description = "Handles Product CRUD Operations")
})
@RestController
@RequestMapping(value="/product", produces = {"application/json"})
public class ProductController {
	
	@Autowired
	ProductService productService;

	@ApiOperation(value = "List of all Products", response = ArrayList.class, tags = "getAllProducts")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@GetMapping()
	ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@ApiOperation(value = "Get Product Details", response = Product.class, tags = "getProductById")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@GetMapping(path={"/{id}"})
	ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	@ApiOperation(value = "Save Product Details", response = Product.class, tags = "saveProduct")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@PostMapping(consumes = {"application/json"})
	ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(productService.saveOrUpdateProduct(product));
	}
}
