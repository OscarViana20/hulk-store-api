package com.oviana.hulkstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.repository.ICategoryRepository;
import com.oviana.hulkstore.service.ICategoryService;
import com.oviana.hulkstore.vo.response.CategoryResponseVO;
import com.querydsl.core.QueryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public List<CategoryResponseVO> findAllCategories() {
		try {
			return categoryRepository.findAllCategories();
		} catch (QueryException e) {
			log.error("Error in find all categories", e);
			throw new HulkStoreException("Error in find all categories", e);
		}
	}

}
