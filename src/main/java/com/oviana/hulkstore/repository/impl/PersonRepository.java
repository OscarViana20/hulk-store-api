package com.oviana.hulkstore.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.entity.PersonEntity;
import com.oviana.hulkstore.entity.QUserEntity;
import com.oviana.hulkstore.repository.IPersonRepository;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class PersonRepository implements IPersonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PersonEntity createPerson(PersonEntity person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findIdByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findIdByDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findPersonIdByUserName(String userName) {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		JPAQuery<Integer> query = new JPAQuery<>(entityManager);
		return query.from(qUserEntity).where(qUserEntity.userName.eq(userName)).select(qUserEntity.personId).fetchOne();
	}

}
