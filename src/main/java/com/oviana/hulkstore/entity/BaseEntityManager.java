package com.oviana.hulkstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseEntityManager {
	
	@PersistenceContext
	protected EntityManager entityManager;
}
