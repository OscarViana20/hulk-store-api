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
 * The Class UserEntity.
 * 
 * @author oviana
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHSTUSER")
public class UserEntity extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The rol id. */
	@Column(name = "ROLID")
	private Integer rolId;
	
	/** The person id. */
	@Column(name = "PERSONID")
	private Integer personId;

	/** The user name. */
	@Column(name = "USERNAME", unique = true)
	private String userName;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/** The rol entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLID", referencedColumnName = "ID", insertable = false, updatable = false)
	private RolEntity rol;
	
	/** The person entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONID", referencedColumnName = "ID", insertable = false, updatable = false)
	private PersonEntity person;
}
