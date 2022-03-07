package com.oviana.hulkstore.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;

@Setter
public class UserDetailVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private boolean status;

	private Collection<? extends GrantedAuthority> rolCol;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.rolCol;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.status;
	}

}
