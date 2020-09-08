package com.oms.item.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

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

import com.oms.item.entity.Product;
import com.oms.item.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

	@Autowired
	MockMvc productController;
	
	@MockBean
	ProductService productService;
	
	Product mockProduct = new Product(1L, "Product 01", "Code 01", 100D);
	Optional<Product> mockProductOptional = Optional.of(mockProduct);
	String jsonProduct = "{\"name\":\"Product 01\",\"code\":\"Code 01\",\"price\":100}";
	
	@Test
	public void getAllProducts() throws Exception {
		Mockito.when(productService.getAllProducts())
			.thenReturn(new ArrayList<Product>(Collections.singletonList(mockProduct)));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/product").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = productController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
	
	@Test
	public void getProductById() throws Exception {
		Mockito.when(productService.getProductById(1l))
			.thenReturn(mockProductOptional);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/product/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = productController.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
	}
	
	@Test
	public void saveProduct() throws Exception {
		Mockito.when(productService.saveProduct(mockProduct))
			.thenReturn(mockProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/product")
				.accept(MediaType.APPLICATION_JSON).content(jsonProduct)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = productController.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();

		System.out.println(response.getStatus());
	}
}
