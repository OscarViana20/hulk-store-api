package com.oviana.hulkstore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oviana.hulkstore.controller.util.ResponseType;
import com.oviana.hulkstore.entity.PaymentTypeEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.service.IPaymentTypeService;

@Lazy
@RestController
@RequestMapping("/api/paymentType")
public class PaymentTypeController {

	private static final String RESTYP = "restyp";
	private static final String MES = "mes";

	@Autowired
	private IPaymentTypeService paymentTypeService;

	/**
	 * Find all payment type.
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "/findAllPaymentType", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<PaymentTypeEntity>> findAllPaymentType() {
		HttpHeaders responseHeaders = new HttpHeaders();
		Collection<PaymentTypeEntity> tiposPago = null;
		try {
			tiposPago = this.paymentTypeService.findAllPaymentType();
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).body(tiposPago);
	}
}
