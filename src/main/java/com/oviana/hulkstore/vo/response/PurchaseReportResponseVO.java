package com.oviana.hulkstore.vo.response;

import java.util.Date;

import lombok.Data;

/**
 * The Class PurchaseReportResponseVO.
 */
@Data
public class PurchaseReportResponseVO {

	/** The id. */
	private Integer id;

	/** The person name. */
	private String personName;

	/** The person last name. */
	private String personLastName;

	/** The total purchase. */
	private Double totalPurchase;

	/** The payment type. */
	private String paymentType;

	/** The created date. */
	private Date createdDate;
}
