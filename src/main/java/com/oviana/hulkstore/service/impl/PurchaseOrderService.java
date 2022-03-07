package com.oviana.hulkstore.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.entity.PurchaseDetailEntity;
import com.oviana.hulkstore.entity.PurchaseOrderEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.repository.IPersonRepository;
import com.oviana.hulkstore.repository.IProductRepository;
import com.oviana.hulkstore.repository.IPurchaseDetailRepository;
import com.oviana.hulkstore.repository.IPurchaseOrderRepository;
import com.oviana.hulkstore.service.IPurchaseOrderService;
import com.oviana.hulkstore.vo.request.PurchaseOrderRequestVO;

/**
 * The Class PurchaseOrderService.
 */
@Service
@Transactional
public class PurchaseOrderService implements IPurchaseOrderService {

	@Autowired
	private IPurchaseDetailRepository purchaseDetailRepository;

	@Autowired
	private IPurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IPersonRepository personRepository;

	@Override
	public void createPurchaseOrder(PurchaseOrderRequestVO purchaseOrderRequestVO) {
		try {

			final PurchaseOrderEntity purchaseOrderEntity = this.createPurchaseOrderEntity(purchaseOrderRequestVO);

			this.createPurchaseDetail(purchaseOrderRequestVO, purchaseOrderEntity.getId());

			this.updateProductQuantity(purchaseOrderRequestVO);

		} catch (HulkStoreException e) {
			throw e;
		} catch (Exception e) {
			throw new HulkStoreException("Error in createPurchaseOrder");
		}
	}

	/**
	 * Creates the purchase order entity.
	 *
	 * @param purchaseOrderRequestVO the purchase order request VO
	 * @return the purchase order entity
	 */
	private PurchaseOrderEntity createPurchaseOrderEntity(PurchaseOrderRequestVO purchaseOrderRequestVO) {

		final Integer personId = this.personRepository.findPersonIdByUserName(purchaseOrderRequestVO.getUsername());

		PurchaseOrderEntity purchaseOrder = PurchaseOrderEntity.builder().orderNumber(generateNumerPurchase())
				.personID(personId).purchaseTotal(totalPurchaseOrder(purchaseOrderRequestVO))
				.paymentTypeId(purchaseOrderRequestVO.getPaymentTypeId()).build();

		this.purchaseOrderRepository.createPurchaseOrder(purchaseOrder);

		return purchaseOrder;
	}

	/**
	 * Creates the purchase detail.
	 *
	 * @param purchaseOrderRequestVO the purchase order request VO
	 * @param purchaseOrderId        the purchase order id
	 */
	private void createPurchaseDetail(PurchaseOrderRequestVO purchaseOrderRequestVO, Integer purchaseOrderId) {

		final Collection<PurchaseDetailEntity> details = new ArrayList<>(
				purchaseOrderRequestVO.getPurchaseDetail().size());

		purchaseOrderRequestVO.getPurchaseDetail()
				.forEach(detail -> details.add(PurchaseDetailEntity.builder().purchaseOrderId(purchaseOrderId)
						.quantity(detail.getQuantity()).productId(detail.getProductId()).build()));

		this.purchaseDetailRepository.createPurchaseDetail(details);
	}

	/**
	 * Update product quantity.
	 *
	 * @param purchaseOrderRequestVO the purchase order request VO
	 */
	private void updateProductQuantity(PurchaseOrderRequestVO purchaseOrderRequestVO) {
		final List<ProductEntity> products = new ArrayList<>();

		purchaseOrderRequestVO.getPurchaseDetail().forEach(detail -> products.add(ProductEntity.builder()
				.id(detail.getProductId()).quantity(detail.getStock() - detail.getQuantity()).build()));

		products.forEach(product -> this.productRepository.updateQuantity(product));
	}

	/**
	 * Generate numer purchase.
	 *
	 * @return the string
	 */
	private static String generateNumerPurchase() {
		Random random = new Random();
		IntStream intStream = random.ints(10, 1, 10);
		StringBuilder code = new StringBuilder();
		intStream.forEach(code::append);
		return code.toString();
	}

	/**
	 * Total purchase order.
	 *
	 * @param purchaseOrderRequestVO the purchase order request VO
	 * @return the double
	 */
	private static Double totalPurchaseOrder(PurchaseOrderRequestVO purchaseOrderRequestVO) {
		return purchaseOrderRequestVO.getPurchaseDetail().stream()
				.mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
	}

}
