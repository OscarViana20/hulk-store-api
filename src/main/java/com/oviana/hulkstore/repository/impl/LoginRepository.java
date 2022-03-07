package com.oviana.hulkstore.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.entity.QRolEntity;
import com.oviana.hulkstore.entity.QUserEntity;
import com.oviana.hulkstore.entity.RolEntity;
import com.oviana.hulkstore.entity.UserEntity;
import com.oviana.hulkstore.repository.ILoginRepository;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class LoginRepository implements ILoginRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserEntity findUserByUserName(String userName) {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		JPAQuery<UserEntity> query = new JPAQuery<>(entityManager);
		return query.from(qUserEntity).where(qUserEntity.userName.eq(userName)).fetchOne();
	}

	@Override
	public RolEntity findRolById(Integer rolId) {
		QRolEntity qRolEntity = QRolEntity.rolEntity;
		JPAQuery<RolEntity> query = new JPAQuery<>(entityManager);
		return query.from(qRolEntity).where(qRolEntity.id.eq(rolId)).fetchOne();
	}

}
