package com.oviana.hulkstore.service;

import com.oviana.hulkstore.vo.request.PurchaseOrderRequestVO;

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
}
