package com.oviana.hulkstore.service;

import java.util.Collection;

import com.oviana.hulkstore.vo.request.PurchaseOrderRequestVO;
import com.oviana.hulkstore.vo.response.PurchaseDetailResponseVO;
import com.oviana.hulkstore.vo.response.PurchaseReportResponseVO;

/**
 * The Interface IPurchaseOrderService.
 */
public interface IPurchaseOrderService {

	/**
	 * Creates the purchase order.
	 *
	 * @param purchaseOrderRequestVO the purchase order request VO
	 */
	void createPurchaseOrder(PurchaseOrderRequestVO purchaseOrderRequestVO);

	/**
	 * Find all purchase order.
	 *
	 * @param userName the user name
	 * @return the collection
	 */
	Collection<PurchaseReportResponseVO> findAllPurchaseOrder(String userName);
	
	/**
	 * Find detail purchase order.
	 *
	 * @param purchaseId the purchase id
	 * @return the collection
	 */
	Collection<PurchaseDetailResponseVO> findDetailPurchaseOrder(Integer purchaseId);
}
