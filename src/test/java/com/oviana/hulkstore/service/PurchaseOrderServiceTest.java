package com.oviana.hulkstore.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oviana.hulkstore.entity.PurchaseOrderEntity;
import com.oviana.hulkstore.repository.IPersonRepository;
import com.oviana.hulkstore.repository.IPurchaseDetailRepository;
import com.oviana.hulkstore.repository.IPurchaseOrderRepository;
import com.oviana.hulkstore.service.impl.PurchaseOrderService;
import com.oviana.hulkstore.vo.request.PurchaseOrderRequestVO;

@RunWith(SpringRunner.class)
@SpringBootTest
class PurchaseOrderServiceTest {

	@Mock
	IPersonRepository personRepository;

	@Mock
	private IPurchaseOrderRepository purchaseOrderRepository;

	@Mock
	IPurchaseDetailRepository purchaseDetailRepository;

	@InjectMocks
	PurchaseOrderService purchaseOrderService;

	@Test
	@DisplayName("Success: Given request when save producto then return created Id")
	public void givenRequestWhenSavePurchaseOrderThenReturnCreatedId() {

		PurchaseOrderRequestVO purchaseOrderRequestVO = new PurchaseOrderRequestVO();
		purchaseOrderRequestVO.setUsername("admin");
		purchaseOrderRequestVO.setPaymentTypeId(1);
		purchaseOrderRequestVO.setPurchaseDetail(new ArrayList<>());

		PurchaseOrderEntity purchaseOrder = PurchaseOrderEntity.builder().orderNumber("1133213").personID(1)
				.purchaseTotal(50d).paymentTypeId(purchaseOrderRequestVO.getPaymentTypeId()).build();

		when(purchaseOrderRepository.createPurchaseOrder(purchaseOrder))
				.thenReturn(PurchaseOrderEntity.builder().id(1).build());

		purchaseOrderService.createPurchaseOrder(purchaseOrderRequestVO);
	}

}
