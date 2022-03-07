package com.oviana.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oviana.hulkstore.controller.util.ResponseType;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.service.IPurchaseOrderService;
import com.oviana.hulkstore.vo.request.PurchaseOrderRequestVO;

@Lazy
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController {

	private static final String MES = "mes";
	private static final String RESTYP = "restyp";

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	/**
	 * Creates the purchase order.
	 *
	 * @param purchaseOrder the purchase order
	 * @return the response entity
	 */
	@PostMapping(value = "/createPurchaseOrder")
	public ResponseEntity<Void> createPurchaseOrder(@RequestBody PurchaseOrderRequestVO purchaseOrder) {
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			this.purchaseOrderService.createPurchaseOrder(purchaseOrder);
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).build();
	}
}
