package com.oms.order.api;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.oms.order.entity.OrderItem;
import com.oms.order.service.OrderItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderItemController.class)
public class OrderItemControllerTest {
	
	@Autowired
	MockMvc orderItemController;
	
	@MockBean
	OrderItemService orderItemService;
	
	OrderItem mockOrderItem = new OrderItem(1L, 1L,"Product 01", "Code 01", 1, 100D, 100D);
	String jsonOrderItem = "{\"orderId\": 1, \"productId\": 1, \"productName\":\"Product 01\",\"productCode\":\"Code 01\",\"quantity\":1,\"price\":100,\"totalPrice\": 100}";
	
	@Test
	public void getAllOrderItems() throws Exception {
		Mockito.when(orderItemService.getAllOrderItemByOrderId(1L))
		.thenReturn(new ArrayList<OrderItem>(Collections.singletonList(mockOrderItem)));
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/order/1/orderitem").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = orderItemController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
	
	@Test
	public void getOrderItemById() throws Exception {
		Mockito.when(orderItemService.getOrderItemById(1L))
		.thenReturn(mockOrderItem);
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/order/1/orderitem/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = orderItemController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
}
