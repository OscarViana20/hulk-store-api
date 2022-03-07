package com.oviana.hulkstore.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Base class for common fields.
 * @author oviana
 *
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status. */
	@Column(name = "STATUS")
    protected String status;
    	
    /** The created date. */
    @Column(name = "CREATEDDATE")
    protected Date createdDate;

    /** The modified date. */
    @Column(name = "MODIFIEDDATE")
    protected Date modifiedDate;
    
    /** The version. */
    @Version
    @Column(name = "VERSION")
    private Integer version;
}
