package com.oms.order.service;

import java.util.List;

import com.oms.model.OrderRequest;
import com.oms.order.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	Order getOrderById(Long id);
	
	Order saveOrder(OrderRequest order);
	
}
