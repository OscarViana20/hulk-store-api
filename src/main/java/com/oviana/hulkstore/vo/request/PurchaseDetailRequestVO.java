package com.oviana.hulkstore.vo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDetailRequestVO {

	/** The product id. */
	private Integer productId;

	/** The quantity. */
	private Integer quantity;

	/** The price. */
	private Double price;

	/** The stock. */
	private Integer stock;
}
