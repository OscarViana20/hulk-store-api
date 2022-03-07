package com.oviana.hulkstore.service;

import java.util.Collection;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.vo.response.ProductResponseVO;

/**
 * The Interface IProductService.
 */
public interface IProductService {

	/**
	 * Find available products.
	 *
	 * @return the collection
	 */
	Collection<ProductResponseVO> findAvailableProducts();
	
	/**
	 * Find stock products.
	 *
	 * @return the collection
	 */
	Collection<ProductResponseVO> findStockProducts();
	
	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the product entity
	 */
	ProductEntity createProduct(ProductEntity product);	
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product entity
	 */
	ProductEntity updateProduct(ProductEntity product);
}
