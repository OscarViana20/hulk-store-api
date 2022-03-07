package com.oviana.hulkstore.repository;

import java.util.List;

import com.oviana.hulkstore.vo.response.CategoryResponseVO;

/**
 * The Interface ICategoryRepository.
 * 
 * @author oviana
 */
public interface ICategoryRepository {

	/**
	 * Find all categories.
	 *
	 * @return the list
	 */
	List<CategoryResponseVO> findAllCategories();
}
