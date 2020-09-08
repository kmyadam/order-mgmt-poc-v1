package com.oms.order.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.exception.NotFoundException;
import com.oms.feign.ProductControllerProxy;
import com.oms.model.Item;
import com.oms.model.OrderRequest;
import com.oms.model.Product;
import com.oms.order.entity.Order;
import com.oms.order.entity.OrderItem;
import com.oms.order.repository.OrderRepository;
import com.oms.order.service.OrderItemService;
import com.oms.order.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ProductControllerProxy productControllerProxy;
	
	@Override
	public List<Order> getAllOrders() {
		return (List<Order>)orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if(!order.isPresent()) {
			throw new NotFoundException("Order not found for id: " + id);
		}
		//Include OrderItem List:
		Order orderDetails = order.get();
		orderDetails.setOrderItems(orderItemService.getAllOrderItemByOrderId(id));
		return orderDetails;
	}

	@Override
	public Order saveOrder(OrderRequest orderRequest) {
		Order order = null;
		if(null != orderRequest) {
			order = prepareOrderFromOrderRequest(orderRequest);
			return orderRepository.save(order);
		}
		return order;
	}
	
	/**
	 * Build the Order by calling order service
	 * @param orderRequest
	 * @return
	 */
	private Order prepareOrderFromOrderRequest(OrderRequest orderRequest) {
		if(null != orderRequest && null != orderRequest.getItems() 
				& !orderRequest.getItems().isEmpty()) {
			Order order = new Order();
			order.setCustomerName(orderRequest.getCustomerName());
			order.setOrderDateDB(new Date());
			order.setShippingAddress(orderRequest.getShippingAddress());
			order = orderRepository.save(order);
			for(Item item : orderRequest.getItems()){
				try {
					Product product = productControllerProxy.getProductById(item.getProductId());
					OrderItem orderItem = new OrderItem();
					orderItem.setOrderId(order.getId());
					orderItem.setProductId(product.getId());
					orderItem.setProductName(product.getName());
					orderItem.setProductCode(product.getCode());
					orderItem.setPrice(product.getPrice());
					orderItem.setQuantity(item.getQuantity());
					orderItemService.saveOrderItem(orderItem);
				} catch(Exception e) {}
			}
			return order;
		}
		return null;
	}

}
