package com.oms.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.order.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
