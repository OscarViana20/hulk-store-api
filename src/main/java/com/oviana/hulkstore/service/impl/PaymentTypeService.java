package com.oviana.hulkstore.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oviana.hulkstore.entity.PaymentTypeEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.repository.IPaymentTypeRepository;
import com.oviana.hulkstore.service.IPaymentTypeService;
import com.querydsl.core.QueryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PaymentTypeService implements IPaymentTypeService {

	@Autowired
	private IPaymentTypeRepository paymentTypeRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<PaymentTypeEntity> findAllPaymentType() {
		try {
			return paymentTypeRepository.findAllPaymentType();
		} catch (QueryException e) {
			log.error("Error in find all categories", e);
			throw new HulkStoreException("Error in find all categories", e);
		}
	}

}
