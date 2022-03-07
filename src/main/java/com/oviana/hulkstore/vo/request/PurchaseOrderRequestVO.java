package com.oviana.hulkstore.vo.request;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class PurchaseOrderRequestVO.
 */
@Getter
@Setter
public class PurchaseOrderRequestVO {

	/** The payment type id. */
	private Integer paymentTypeId;

	/** The username. */
	private String username;

	/** The purchase detail. */
	private Collection<PurchaseDetailRequestVO> purchaseDetail;
}
