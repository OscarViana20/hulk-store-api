package com.oviana.hulkstore.repository.impl;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.PurchaseOrderEntity;
import com.oviana.hulkstore.entity.QPaymentTypeEntity;
import com.oviana.hulkstore.entity.QPersonEntity;
import com.oviana.hulkstore.entity.QPurchaseOrderEntity;
import com.oviana.hulkstore.repository.IPurchaseOrderRepository;
import com.oviana.hulkstore.vo.response.ProductResponseVO;
import com.oviana.hulkstore.vo.response.PurchaseReportResponseVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

@Lazy
@Repository
public class PurchaseOrderRepository implements IPurchaseOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PurchaseOrderEntity createPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
		purchaseOrder.setCreatedDate(Date.from(Instant.now()));
		purchaseOrder.setStatus(HulkStoreConstants.ACTIVE_STATUS);
		entityManager.persist(purchaseOrder);
		return purchaseOrder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<PurchaseReportResponseVO> findAllPurchaseOrderByPersonId(Integer personId) {
		
		final QPurchaseOrderEntity qPurchaseOrderEntity = QPurchaseOrderEntity.purchaseOrderEntity;
		final QPersonEntity qPersonEntity = QPersonEntity.personEntity;
		final QPaymentTypeEntity qPaymentTypeEntity = QPaymentTypeEntity.paymentTypeEntity;

		JPAQuery<ProductResponseVO> query = new JPAQuery<>(entityManager);

		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qPurchaseOrderEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qPersonEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qPaymentTypeEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS));

		return query
				.select(Projections.bean(PurchaseReportResponseVO.class, 
						qPurchaseOrderEntity.id, 
						qPersonEntity.name.as("personName"),
						qPersonEntity.lastName.as("personLastName"),
						qPurchaseOrderEntity.purchaseTotal.as("totalPurchase"), 
						qPaymentTypeEntity.description.as("paymentType"), 
						qPurchaseOrderEntity.createdDate))
				.from(qPurchaseOrderEntity)
					.innerJoin(qPurchaseOrderEntity.personEntity, qPersonEntity)
					.innerJoin(qPurchaseOrderEntity.paymentType, qPaymentTypeEntity).where(predicate)
					.orderBy(qPurchaseOrderEntity.createdDate.desc()).fetch();
	}

}
