package com.oviana.hulkstore.repository.impl;

import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.PurchaseOrderEntity;
import com.oviana.hulkstore.repository.IPurchaseOrderRepository;

@Lazy
@Repository
public class PurchaseOrderRepository implements IPurchaseOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Creates the purchase order.
	 *
	 * @param purchaseOrder the purchase order
	 * @return the purchase order entity
	 */
	@Override
	public PurchaseOrderEntity createPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
		purchaseOrder.setCreatedDate(Date.from(Instant.now()));
		purchaseOrder.setStatus(HulkStoreConstants.ACTIVE_STATUS);
		entityManager.persist(purchaseOrder);
		return purchaseOrder;
	}

}
