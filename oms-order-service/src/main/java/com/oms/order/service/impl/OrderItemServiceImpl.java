package com.oms.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.entity.OrderItem;
import com.oms.order.repository.OrderItemRepository;
import com.oms.order.service.OrderItemService;


@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public List<OrderItem> getAllOrderItemByOrderId(Long orderId) {
		return orderItemRepository.findAllByOrderId(orderId);
	}

	@Override
	public OrderItem getOrderItemById(Long id) {
		Optional<OrderItem> orderItem = orderItemRepository.findById(id);
		if(orderItem.isPresent()) {
			return orderItem.get();
		}
		return null;
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

}
