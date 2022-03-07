package com.oviana.hulkstore.vo.response;

import lombok.Data;

/**
 * The Class CategoryResponseVO.
 */
@Data
public class CategoryResponseVO {

	/** The id. */
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The category type. */
	private String categoryType;
}
