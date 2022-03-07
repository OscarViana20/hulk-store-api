package com.oviana.hulkstore.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.entity.QCategoryEntity;
import com.oviana.hulkstore.entity.QCategoryTypeEntity;
import com.oviana.hulkstore.repository.ICategoryRepository;
import com.oviana.hulkstore.vo.response.CategoryResponseVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * Implementation for category data persistence
 * 
 * @author oviana
 */
@Lazy
@Repository
public class CategoryRepository implements ICategoryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CategoryResponseVO> findAllCategories() {
		final QCategoryEntity qCategoryEntity = QCategoryEntity.categoryEntity;
        final QCategoryTypeEntity qCategoryTypeEntity = QCategoryTypeEntity.categoryTypeEntity;
        
        JPAQuery<CategoryResponseVO> query = new JPAQuery<>(entityManager);

        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(qCategoryEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS))
                .and(qCategoryTypeEntity.status.eq(HulkStoreConstants.ACTIVE_STATUS));

        return query.select(Projections.bean(CategoryResponseVO.class,
        		qCategoryEntity.id,
        		qCategoryEntity.name,
        		qCategoryEntity.description,
        		qCategoryEntity.categoryType.name.as("categoryType")
        )).from(qCategoryEntity)
                .innerJoin(qCategoryEntity.categoryType, qCategoryTypeEntity)
                .where(predicate)
                .orderBy(qCategoryEntity.createdDate.desc())
                .fetch();
	}

}
