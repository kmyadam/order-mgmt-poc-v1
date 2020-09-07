package com.oms.item.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.item.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
