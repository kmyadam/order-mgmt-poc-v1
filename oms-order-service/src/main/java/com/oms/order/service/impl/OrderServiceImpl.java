package com.oms.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.entity.Order;
import com.oms.order.repository.OrderRepository;
import com.oms.order.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		return (List<Order>)orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		return null;
	}

	@Override
	public Order saveOrUpdateOrder(Order Order) {
		return orderRepository.save(Order);
	}

}
