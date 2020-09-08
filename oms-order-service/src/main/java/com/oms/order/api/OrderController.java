package com.oms.order.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oms.model.OrderRequest;
import com.oms.order.entity.Order;
import com.oms.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/order" , tags = {"Order Controller"})
@RestController
@RequestMapping(value="/order", produces = {"application/json"})
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@ApiOperation(value = "List of all Orders", response = ArrayList.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@GetMapping()
	ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}
	
	@ApiOperation(value = "Get Order Details", response = Order.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@GetMapping(path={"/{id}"})
	ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(orderService.getOrderById(id));
	}
	
	@ApiOperation(value = "Save Order Details", response = Order.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Created"),
	        @ApiResponse(code =404, message = "404 error")
	    })
	@PostMapping(consumes = {"application/json"})
	ResponseEntity<Order> saveOrder(@Valid @RequestBody OrderRequest order) throws Exception {
		Order savedOrder = orderService.saveOrder(order);
		if(null == savedOrder) {
			throw new Exception("Unable to create order...");
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getId()).toUri();
		return ResponseEntity.created(location).body(savedOrder);
	}
}
