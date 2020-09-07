package com.oms.order.service;

import java.util.List;
import java.util.Optional;

import com.oms.model.OrderRequest;
import com.oms.order.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	Optional<Order> getOrderById(Long id);
	
	Order saveOrder(OrderRequest order);
	
}
