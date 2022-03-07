package com.oviana.hulkstore.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class PurchaseOrderEntity.
 * 
 * @author oviana
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHSTPURCHASEORDER")
public class PurchaseOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "PERSONID")
	private Integer personID;

	@Column(name = "PAYMENTTYPEID")
	private Integer paymentTypeId;

	@Column(name = "ORDERNUMBER")
	private String orderNumber;

	@Column(name = "PURCHASETOTAL")
	private Double purchaseTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONID", referencedColumnName = "ID", insertable = false, updatable = false)
	private PersonEntity personEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENTTYPEID", referencedColumnName = "ID", insertable = false, updatable = false)
	private PaymentTypeEntity paymentType;

	@OneToMany(mappedBy = "purchaseOrder")
	private List<PurchaseDetailEntity> detallesCompra;

}
