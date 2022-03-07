package com.oviana.hulkstore.repository.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.PaymentTypeEntity;
import com.oviana.hulkstore.entity.QPaymentTypeEntity;
import com.oviana.hulkstore.repository.IPaymentTypeRepository;
import com.querydsl.jpa.impl.JPAQuery;

@Lazy
@Repository
public class PaymentTypeRepository implements IPaymentTypeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<PaymentTypeEntity> findAllPaymentType() {
		QPaymentTypeEntity qPaymentTypeEntity = QPaymentTypeEntity.paymentTypeEntity;
		JPAQuery<PaymentTypeEntity> query = new JPAQuery<>(entityManager);
		return query.from(qPaymentTypeEntity).where(qPaymentTypeEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
				.fetch();
	}

}
