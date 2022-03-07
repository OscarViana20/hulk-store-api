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

import com.oviana.hulkstore.repository.IPaymentTypeRepository;
import com.oviana.hulkstore.service.impl.PaymentTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentTypeServiceTest {

	@Mock
	IPaymentTypeRepository paymentTypeRepository;

	@InjectMocks
	PaymentTypeService paymentTypeService;

	@Test
	public void whenFindAvailableCategoriesThenReturn() {
		when(paymentTypeRepository.findAllPaymentType()).thenReturn(new ArrayList<>());

		assertThat(paymentTypeService.findAllPaymentType()).isEmpty();

		verify(paymentTypeRepository, times(1)).findAllPaymentType();
	}

}
