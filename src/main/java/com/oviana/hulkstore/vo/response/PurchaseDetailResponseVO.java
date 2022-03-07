package com.oviana.hulkstore.vo.response;

import lombok.Data;

/**
 * The Class PurchaseDetailResponseVO.
 */
@Data
public class PurchaseDetailResponseVO {

	/** The barcode. */
	private String barcode;

	/** The name. */
	private String name;

	/** The quantity. */
	private Integer quantity;

	/** The category name. */
	private String categoryName;
}
