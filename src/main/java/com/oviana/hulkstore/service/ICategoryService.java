package com.oviana.hulkstore.service;

import java.util.Collection;

import com.oviana.hulkstore.vo.response.CategoryResponseVO;

/**
 * The Interface ICategoryService.
 */
public interface ICategoryService {

	/**
	 * Find all categories.
	 *
	 * @return the collection
	 */
	Collection<CategoryResponseVO> findAllCategories();
}
