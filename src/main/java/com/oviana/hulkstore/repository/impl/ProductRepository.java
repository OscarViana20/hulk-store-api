package com.oviana.hulkstore.repository.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.entity.QCategoryEntity;
import com.oviana.hulkstore.entity.QCategoryTypeEntity;
import com.oviana.hulkstore.entity.QProductEntity;
import com.oviana.hulkstore.repository.IProductRepository;
import com.oviana.hulkstore.vo.response.ProductResponseVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

/**
 * Implementation for product data persistence
 * 
 * @author oviana
 */
@Lazy
@Repository
public class ProductRepository implements IProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductEntity createProduct(ProductEntity product) {
		product.setCreatedDate(Date.from(Instant.now()));
		product.setStatus(HulkStoreConstants.ACTIVE_STATUS);
		entityManager.persist(product);
		return product;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductEntity updateProduct(ProductEntity product) {

		final QProductEntity qProductEntity = QProductEntity.productEntity;

		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

		queryFactory.update(qProductEntity).where(qProductEntity.id.eq(product.getId()))
				.set(qProductEntity.name, product.getName()).set(qProductEntity.barcode, product.getBarcode())
				.set(qProductEntity.description, product.getDescription()).set(qProductEntity.price, product.getPrice())
				.set(qProductEntity.quantity, product.getQuantity())
				.set(qProductEntity.categoryId, product.getCategoryId()).set(qProductEntity.status, product.getStatus())
				.execute();

		return product;
	}

	@Override
	public void updateQuantity(ProductEntity product) {
		QProductEntity qProductEntity = QProductEntity.productEntity;
		JPAUpdateClause update = new JPAUpdateClause(entityManager, qProductEntity);
		update.set(qProductEntity.quantity, product.getQuantity()).where(qProductEntity.id.eq(product.getId()))
				.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProductResponseVO> findAvailableProducts() {
		return this.findAllProducts(Boolean.FALSE);
	}

	@Override
	public List<ProductResponseVO> findStockProducts() {
		return this.findAllProducts(Boolean.TRUE);
	}

	/**
	 * Find all products.
	 *
	 * @param stockData true for products in stock
	 * @return the list
	 */
	private List<ProductResponseVO> findAllProducts(Boolean stockData) {

		final QProductEntity qProductEntity = QProductEntity.productEntity;
		final QCategoryEntity qCategoriaEntity = QCategoryEntity.categoryEntity;
		final QCategoryTypeEntity qCategoryTypeEntity = QCategoryTypeEntity.categoryTypeEntity;

		JPAQuery<ProductResponseVO> query = new JPAQuery<>(entityManager);

		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qProductEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qCategoriaEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS));

		if (BooleanUtils.isTrue(stockData)) {
			predicate.and(qProductEntity.quantity.gt(0));
		}

		return query
				.select(Projections.bean(ProductResponseVO.class, qProductEntity.id, qProductEntity.categoryId,
						qProductEntity.barcode, qProductEntity.name, qProductEntity.price, qProductEntity.quantity,
						qProductEntity.category.name.as("categoryName"),
						qProductEntity.category.categoryType.name.as("categoryType")))
				.from(qProductEntity).innerJoin(qProductEntity.category, qCategoriaEntity)
				.innerJoin(qCategoriaEntity.categoryType, qCategoryTypeEntity).where(predicate)
				.orderBy(qProductEntity.createdDate.desc()).fetch();
	}

}
