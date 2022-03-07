package com.oviana.hulkstore.security;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoginRequest.
 */
@Getter
@Setter
public class LoginRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The username. */
	private String username;

	/** The password. */
	private String password;
}
