package com.oms.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oms.order.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{

	List<OrderItem> findAllByOrderId(@Param("orderId") Long orderId);
	
}
