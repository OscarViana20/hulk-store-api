package com.oviana.hulkstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class CategoryEntity.
 * 
 * @author oviana
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHSTCATEGORY")
public class CategoryEntity extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The category type id. */
	@Column(name = "CATEGORYTYPEID")
	private Integer categoryTypeId;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The description. */
	@Column(name = "DESCRIPTION")
	private String description;

	/** The category type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYTYPEID", referencedColumnName = "ID", insertable = false, updatable = false)
	private CategoryTypeEntity categoryType;
}
