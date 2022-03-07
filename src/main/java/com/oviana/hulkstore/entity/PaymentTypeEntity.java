package com.oviana.hulkstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class PaymentTypeEntity.
 * 
 * @author oviana
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHSTPAYMENTTYPE")
public class PaymentTypeEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The description. */
	@Column(name = "DESCRIPTION")
	private String description;
}
