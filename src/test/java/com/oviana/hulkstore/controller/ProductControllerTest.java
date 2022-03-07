package com.oviana.hulkstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.service.IProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IProductService productService;

	//@Test
	@DisplayName("Success: Given request when create product then return ok")
	public void givenRequestWhenCreateProductThenReturnOk() throws Exception {

		Mockito.when(productService.createProduct(ArgumentMatchers.any()))
				.thenReturn(ProductEntity.builder().id(1).build());

		mvc.perform(post("/api/product/createProduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(ProductEntity.builder().build())))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(1));
	}

}
