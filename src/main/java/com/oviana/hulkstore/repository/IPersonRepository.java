package com.oviana.hulkstore.repository;

import com.oviana.hulkstore.entity.PersonEntity;

/**
 * The Interface IPersonRepository.
 * @author oviana
 */
public interface IPersonRepository {

	/**
	 * Creates the person.
	 * @author oviana
	 *
	 * @param person the person
	 * @return the person entity
	 */
	PersonEntity createPerson(PersonEntity person);

	/**
	 * Find id by email.
	 * @author oviana
	 *
	 * @param email the email
	 * @return the integer
	 */
	Integer findIdByEmail(String email);
	
	/**
	 * Find id by DNI.
	 *
	 * @param dni the dni
	 * @return the integer
	 */
	Integer findIdByDNI(String dni);
	
	/**
	 * Find person id by user name.
	 *
	 * @param userName the user name
	 * @return the integer
	 */
	Integer findPersonIdByUserName(String userName);
}
