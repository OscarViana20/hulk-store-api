package com.oviana.hulkstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.repository.IProductRepository;
import com.oviana.hulkstore.service.impl.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

	@Mock
	IProductRepository productRepository;

	@InjectMocks
	ProductService productService;

	@Test
	@DisplayName("Success: Given request when save producto then return created Id")
	public void givenRequestWhenSaveProductThenReturnCreatedId() {

		ProductEntity productEntity = ProductEntity.builder().categoryId(1).barcode("554433")
				.description("Camiseta barman kids").price(7d).quantity(7).build();

		when(productRepository.createProduct(any())).thenReturn(ProductEntity.builder().id(1).build());

		ProductEntity create = productService.createProduct(productEntity);

		assertEquals(1, create.getId());
	}

	@Test
	void givenRequestWhenUpdateProductThenReturnId() {

		ProductEntity productEntity = ProductEntity.builder().categoryId(1).barcode("554433")
				.description("Camiseta barman kids").price(7d).quantity(7).build();

		when(productRepository.updateProduct(any())).thenReturn(ProductEntity.builder().id(1).build());

		ProductEntity update = productService.updateProduct(productEntity);

		assertEquals(1, update.getId());
	}

	@Test
	public void whenFindAvailableProductsThenReturn() {
		when(productRepository.findAvailableProducts()).thenReturn(new ArrayList<>());

		assertThat(productService.findAvailableProducts()).isEmpty();

		verify(productRepository, times(1)).findAvailableProducts();
	}

	@Test
	public void whenFindStockProductsThenReturn() {
		when(productRepository.findStockProducts()).thenReturn(new ArrayList<>());

		assertThat(productService.findStockProducts()).isEmpty();

		verify(productRepository, times(1)).findStockProducts();
	}

}
