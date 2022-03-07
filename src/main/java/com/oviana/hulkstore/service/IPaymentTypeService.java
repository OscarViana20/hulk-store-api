package com.oviana.hulkstore.service;

import java.util.Collection;

import com.oviana.hulkstore.entity.PaymentTypeEntity;

/**
 * The Interface IPaymentTypeService.
 */
public interface IPaymentTypeService {

	/**
	 * Find all payment type.
	 *
	 * @return the collection
	 */
	Collection<PaymentTypeEntity> findAllPaymentType();
}
