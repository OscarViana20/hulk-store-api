package com.oviana.hulkstore.repository;

import java.util.Collection;

import com.oviana.hulkstore.entity.PurchaseOrderEntity;
import com.oviana.hulkstore.vo.response.PurchaseReportResponseVO;

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

	/**
	 * Find all purchase order.
	 *
	 * @param personId the person id
	 * @return the collection
	 */
	Collection<PurchaseReportResponseVO> findAllPurchaseOrderByPersonId(Integer personId);
}
