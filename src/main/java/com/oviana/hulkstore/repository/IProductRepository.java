package com.oviana.hulkstore.repository;

import java.util.List;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.vo.response.ProductResponseVO;

/**
 * The Interface IProductRepository.
 */
public interface IProductRepository {
		
    /**
     * Creates the product.
     *
     * @author oviana
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
    
    /**
     * Update quantity.
     *
     * @param product the product
     */
    void updateQuantity(ProductEntity product);
    
    /**
     * Find available registered products.
     *
     * @return the list
     */
    List<ProductResponseVO> findAvailableProducts();
    
    /**
     * Find stock products.
     *
     * @return the list
     */
    List<ProductResponseVO> findStockProducts();
}
