package com.oviana.hulkstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oviana.hulkstore.repository.ICategoryRepository;
import com.oviana.hulkstore.service.impl.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceTest {

	@Mock
	ICategoryRepository categoryRepository;

	@InjectMocks
	CategoryService categoryService;

	@Test
	public void whenFindAvailableCategoriesThenReturn() {
		when(categoryRepository.findAllCategories()).thenReturn(new ArrayList<>());

		assertThat(categoryService.findAllCategories()).isEmpty();

		verify(categoryRepository, times(1)).findAllCategories();
	}

}
