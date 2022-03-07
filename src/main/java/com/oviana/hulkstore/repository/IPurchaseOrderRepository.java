package com.oviana.hulkstore.repository;

import com.oviana.hulkstore.entity.PurchaseOrderEntity;

/**
 * The Interface IPurchaseOrderRepository.
 * 
 * @author oviana
 */
public interface IPurchaseOrderRepository {

	/**
	 * Creates the purchase order.
	 * 
	 * @author oviana
	 *
	 * @param purchaseOrder the purchase order
	 * @return the purchase order entity
	 */
	PurchaseOrderEntity createPurchaseOrder(PurchaseOrderEntity purchaseOrder);
}
