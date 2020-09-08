package com.oms.order.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.entity.OrderItem;
import com.oms.order.service.OrderItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/order" , tags = {"Order Item Controller"})
@RestController
@RequestMapping(value="/order", produces = {"application/json"})
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;

	@ApiOperation(value = "List of all Order Items", response = ArrayList.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@GetMapping(path={"/{orderId}/orderitem"})
	ResponseEntity<List<OrderItem>> getAllOrderItemByOrderId(@PathVariable("orderId") Long orderId){
		return ResponseEntity.ok().body(orderItemService.getAllOrderItemByOrderId(orderId));
	}
	
	@ApiOperation(value = "Get Order Item Details", response = OrderItem.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error")
	    })
	@GetMapping(path={"/orderitem/{itemId}"})
	ResponseEntity<OrderItem> getOrderItemById(@PathVariable("itemId") Long itemId) {
		return ResponseEntity.ok().body(orderItemService.getOrderItemById(itemId));
	}
}
