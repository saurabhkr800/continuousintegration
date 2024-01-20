package com.niit.product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.product.controller.ProductController;
import com.niit.product.model.Product;
import com.niit.product.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ProductService service;
	
	@InjectMocks
	private ProductController controller;
	
	private Product product;
	
	@BeforeEach
	void setUp() throws Exception {
		product = new Product("P01", "Pen", 10, "Yes");
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testSaveProduct() throws Exception {
		when(service.saveProducts(any())).thenReturn(true);
		mockMvc.perform(
				post("/productstore/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(product))
				)
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print()
		);
	}
	
	@Test
	public void testGetAllProduct() throws Exception {
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		when(service.getAllProducts()).thenReturn(productList);
		mockMvc.perform(
				get("/productstore/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(product))
				)
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print()
		);
		productList.clear();
	}
	
	@Test
	public void testGetAllAvailableProduct() throws Exception {
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		when(service.getAllAvailableProducts()).thenReturn(productList);
		mockMvc.perform(
				get("/productstore/product/instock")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(product))
				)
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print()
		);
		productList.clear();
	}
	
	@Test
	public void testDeleteProduct() throws Exception {
		when(service.updateProducts(any())).thenReturn(true);
		mockMvc.perform(
				put("/productstore/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(product))
				)
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print()
		);
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		when(service.deleteProducts(anyString())).thenReturn(true);
		mockMvc.perform(
				delete("/productstore/product/P01")
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print()
		);
	}
	
	public static String jsonToString(final Object obj)throws JsonProcessingException
	{
		String result=null;
		
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writeValueAsString(obj);
			result=jsonContent;
		}
		catch(JsonProcessingException e)
		{
			result="Json Processing Error";
		}
		return result;
	}
	
	
}
