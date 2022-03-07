package com.oviana.hulkstore.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.RolEntity;
import com.oviana.hulkstore.entity.UserEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.repository.ILoginRepository;
import com.oviana.hulkstore.vo.UserDetailVO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ILoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserEntity user = loginRepository.findUserByUserName(username);
			if (user == null) {
				throw new UsernameNotFoundException(String.format("User not exists '%s'.", username));
			}
			user.setRol(loginRepository.findRolById(user.getRolId()));
			return create(user);
		} catch (Exception e) {
			throw new HulkStoreException("Error find user by username", e);
		}
	}

	private UserDetailVO create(UserEntity user) {
		UserDetailVO userDetail = new UserDetailVO();
		userDetail.setUsername(user.getUserName());
		userDetail.setPassword(user.getPassword());
		userDetail.setStatus(user.getStatus().equals(HulkStoreConstants.ACTIVE_STATUS));
		userDetail.setRolCol(mapearRoles(user.getRol()));
		return userDetail;
	}

	private Collection<? extends GrantedAuthority> mapearRoles(RolEntity rolEntity) {
		Set<RolEntity> rolCol = new HashSet<>();
		rolCol.add(rolEntity);
		return rolCol.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
	}
}
