package com.oviana.hulkstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.repository.IProductRepository;
import com.oviana.hulkstore.service.impl.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	IProductRepository productRepository;

	@InjectMocks
	ProductService productService;

	@Test
	@DisplayName("Success: Given request when save producto then return created Id")
	public void givenProductoEntity_whenSavedProductoEntity_thenProductoEntitySave() {

		// given - precondition or setup
		ProductEntity productEntity = ProductEntity.builder().categoryId(1).barcode("554433")
				.description("Camiseta barman kids").price(7d).quantity(7).build();

		when(productRepository.createProduct(any())).thenReturn(ProductEntity.builder().id(1).build());

		ProductEntity message = productService.createProduct(productEntity);

		assertEquals(3, message.getId());
	}

	@Test
	public void given_when_then() {
		when(productRepository.findAvailableProducts()).thenReturn(new ArrayList<>());

		assertThat(productService.findAvailableProducts()).isEmpty();

		verify(productRepository, times(1)).findAvailableProducts();
	}
}
