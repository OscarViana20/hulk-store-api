package com.oviana.hulkstore.repository.impl;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.PurchaseDetailEntity;
import com.oviana.hulkstore.repository.IPurchaseDetailRepository;

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

}
