package com.oviana.hulkstore.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.repository.IProductRepository;
import com.oviana.hulkstore.service.IProductService;
import com.oviana.hulkstore.vo.response.ProductResponseVO;
import com.querydsl.core.QueryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ProductResponseVO> findAvailableProducts() {
		try {
			return productRepository.findAvailableProducts();
		} catch (QueryException e) {
			log.error("Error in find available products", e);
			throw new HulkStoreException("Error in find available products", e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ProductResponseVO> findStockProducts() {
		try {
			return productRepository.findStockProducts();
		} catch (QueryException e) {
			log.error("Error in find available products", e);
			throw new HulkStoreException("Error in find available products", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductEntity createProduct(ProductEntity product) {
		try {
			return productRepository.createProduct(product);
		} catch (QueryException e) {
			log.error("Error in create product", e);
			throw new HulkStoreException("Error in create product", e);
		}
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		try {
			return productRepository.updateProduct(product);
		} catch (QueryException e) {
			log.error("Error in update product", e);
			throw new HulkStoreException("Error in update product", e);
		}
	}
}
