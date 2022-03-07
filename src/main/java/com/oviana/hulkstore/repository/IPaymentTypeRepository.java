package com.oviana.hulkstore.repository;

import java.util.Collection;

import com.oviana.hulkstore.entity.PaymentTypeEntity;

/**
 * The Interface IPaymentTypeRepository.
 * 
 * @author oviana
 */
public interface IPaymentTypeRepository {

	/**
	 * Find all payment type.
	 * 
	 * @author oviana
	 *
	 * @return the collection
	 */
	Collection<PaymentTypeEntity> findAllPaymentType();
}
