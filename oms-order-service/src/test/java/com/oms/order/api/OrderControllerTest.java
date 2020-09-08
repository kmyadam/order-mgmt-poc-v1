package com.oms.order.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.oms.model.Item;
import com.oms.model.OrderRequest;
import com.oms.order.entity.Order;
import com.oms.order.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	MockMvc orderController;
	
	@MockBean
	OrderService orderService;
	
	Order mockOrder = new Order(1L, "Product 01", new Date(), "Code 01");
	String jsonOrder = "{\"id\":1,\"customerName\":\"Customer 01\",\"orderDate\":\"09/10/2020\",\"shippingAddress\":\"Street 123, City, State, Pin\"}";
	
	OrderRequest mockOrderRequest = new OrderRequest("Customer 01", "Street 123", new HashSet<Item>(Collections.singletonList(new Item(1L,1))));
	String jsonOrderRequest = "{\"customerName\": \"Customer 02\",\"items\": [{\"id\": 1,\"quantity\": 1}],\"shippingAddress\": \"Street 124\"}";
	
	@Test
	public void getAllOrders() throws Exception {
		Mockito.when(orderService.getAllOrders())
		.thenReturn(new ArrayList<Order>(Collections.singletonList(mockOrder)));
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/order").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = orderController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
	
	@Test
	public void getOrderById() throws Exception {
		Mockito.when(orderService.getOrderById(1L))
		.thenReturn(mockOrder);
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/order/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = orderController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
	
	@Test
	public void saveOrder() throws Exception {
		Mockito.when(orderService.saveOrder(mockOrderRequest))
		.thenReturn(mockOrder);
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order")
				.accept(MediaType.APPLICATION_JSON).content(jsonOrderRequest)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = orderController.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
	
		System.out.println(response.getStatus());
	}
}
