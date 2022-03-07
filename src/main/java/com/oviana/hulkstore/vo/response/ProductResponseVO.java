package com.oviana.hulkstore.vo.response;

import lombok.Data;

/**
 * The Class ProductResponseVO.
 */
@Data
public class ProductResponseVO {

	/** The id. */
	private Integer id;
	
	/** The category id. */
	private Integer categoryId;
	
	/** The barcode. */
	private String barcode;
	
	/** The name. */
	private String name;
	
	/** The price. */
	private Double price;
	
	/** The quantity. */
	private Integer quantity;
	
	/** The category name. */
	private String categoryName;
	
	/** The category type. */
	private String categoryType;
}
