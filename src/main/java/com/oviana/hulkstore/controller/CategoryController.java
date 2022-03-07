package com.oviana.hulkstore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oviana.hulkstore.controller.util.ResponseType;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.service.ICategoryService;
import com.oviana.hulkstore.vo.response.CategoryResponseVO;

@Lazy
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private static final String MES = "mes";
	private static final String RESTYP = "restyp";

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = "/findAllCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CategoryResponseVO>> findAvailableProducts() {
		HttpHeaders responseHeaders = new HttpHeaders();
		Collection<CategoryResponseVO> categories = null;
		try {
			categories = this.categoryService.findAllCategories();
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).body(categories);
	}
}
