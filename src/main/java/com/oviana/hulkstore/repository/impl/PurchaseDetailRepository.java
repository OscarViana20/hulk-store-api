package com.oviana.hulkstore.repository.impl;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.PurchaseDetailEntity;
import com.oviana.hulkstore.entity.QCategoryEntity;
import com.oviana.hulkstore.entity.QProductEntity;
import com.oviana.hulkstore.entity.QPurchaseDetailEntity;
import com.oviana.hulkstore.repository.IPurchaseDetailRepository;
import com.oviana.hulkstore.vo.response.PurchaseDetailResponseVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

@Lazy
@Repository
public class PurchaseDetailRepository implements IPurchaseDetailRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createPurchaseDetail(Collection<PurchaseDetailEntity> PurchaseDetailCol) {
		PurchaseDetailCol.stream().forEach(detail -> {
			detail.setCreatedDate(new Date());
			detail.setStatus(HulkStoreConstants.ACTIVE_STATUS);
		});
		PurchaseDetailCol.forEach(entityManager::persist);
		entityManager.flush();
	}

	@Override
	public Collection<PurchaseDetailEntity> findPurchaseDetailByUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PurchaseDetailResponseVO> findDetailPurchaseOrder(Integer purchaseId) {
		
		final QPurchaseDetailEntity qPurchaseDetailEntity = QPurchaseDetailEntity.purchaseDetailEntity;
		final QProductEntity qProductEntity = QProductEntity.productEntity;
		final QCategoryEntity qCategoryEntity = QCategoryEntity.categoryEntity;

		JPAQuery<PurchaseDetailResponseVO> query = new JPAQuery<>(entityManager);

		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qPurchaseDetailEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qProductEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qCategoryEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.and(qPurchaseDetailEntity.purchaseOrderId.eq(purchaseId));

		return query
				.select(Projections.bean(PurchaseDetailResponseVO.class, 
						qProductEntity.barcode,
						qProductEntity.name,
						qPurchaseDetailEntity.quantity,
						qCategoryEntity.name.as("categoryName")))
				.from(qPurchaseDetailEntity)
					.innerJoin(qPurchaseDetailEntity.product, qProductEntity)
					.innerJoin(qProductEntity.category, qCategoryEntity).where(predicate)
					.orderBy(qPurchaseDetailEntity.createdDate.desc()).fetch();
	}

}
