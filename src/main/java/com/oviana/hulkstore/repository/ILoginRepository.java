package com.oviana.hulkstore.repository;

import com.oviana.hulkstore.entity.RolEntity;
import com.oviana.hulkstore.entity.UserEntity;

/**
 * The Interface ILoginRepository.
 */
public interface ILoginRepository {

	/**
	 * Find user by user name.
	 * @author oviana
	 *
	 * @param userName the user name
	 * @return the user entity
	 */
	UserEntity findUserByUserName(String userName);
	
	/**
	 * Find rol by id.
	 *
	 * @param rolId the rol id
	 * @return the rol entity
	 */
	RolEntity findRolById(Integer rolId);
}
