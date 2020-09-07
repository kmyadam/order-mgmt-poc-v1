package com.oms.order.service;

import java.util.List;

import com.oms.order.entity.OrderItem;

public interface OrderItemService {
	
	List<OrderItem> getAllOrderItemByOrderId(Long orderId);
	
	OrderItem getOrderItemById(Long id);
	
	OrderItem saveOrUpdateOrderItem(OrderItem orderItem);
	
}
