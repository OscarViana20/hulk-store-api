package com.oviana.hulkstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.repository.IProductRepository;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTest {

	//@Mock
    @MockBean
    IProductRepository productRepository;
    
    // @InjectMocks
    @Autowired
    IProductService productService;

    //JUnit test for
    @Test
    public void givenArticuloEntity_whenSavedArticuloEntity_thenArticuloEntitySave() {        
    	
    	//given - precondition or setup
        ProductEntity productEntity = ProductEntity.builder()
                .categoryId(1)
                .barcode("554433")
                .description("Camiseta barman kids")
                .price(7d)
                .quantity(7)
                .build();
        
        //when - action or the behavior that we are going test
        productService.createProduct(productEntity);
        
        //then - verify output
        verify(productRepository, times(1)).createProduct(productEntity);
    }

    //JUnit test for
    @Test
    public void given_when_then() {
        when(productRepository.findAvailableProducts()).thenReturn(new ArrayList<>());
        
        assertThat(productService.findAvailableProducts()).isEmpty();
        
        verify(productRepository, times(1)).findAvailableProducts() ;
    }
}
