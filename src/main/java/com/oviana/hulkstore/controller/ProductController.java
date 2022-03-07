package com.oviana.hulkstore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oviana.hulkstore.common.HulkStoreConstants;
import com.oviana.hulkstore.controller.util.ResponseType;
import com.oviana.hulkstore.entity.ProductEntity;
import com.oviana.hulkstore.exception.HulkStoreException;
import com.oviana.hulkstore.service.IProductService;
import com.oviana.hulkstore.vo.response.ProductResponseVO;

@Lazy
@RestController
@RequestMapping("/api/product")
public class ProductController {

	private static final String MES = "mes";
	private static final String RESTYP = "restyp";

	@Autowired
	private IProductService productService;

	/**
	 * Find available products.
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "/findAvailableProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ProductResponseVO>> findAvailableProducts() {
		HttpHeaders responseHeaders = new HttpHeaders();
		Collection<ProductResponseVO> articulos = null;
		try {
			articulos = this.productService.findAvailableProducts();
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).body(articulos);
	}
	
	/**
	 * Find stock products.
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "/findStockProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ProductResponseVO>> findStockProducts() {
		HttpHeaders responseHeaders = new HttpHeaders();
		Collection<ProductResponseVO> articulos = null;
		try {
			articulos = this.productService.findStockProducts();
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).body(articulos);
	}

	/**
	 * Creates the product.
	 *
	 * @param productEntity the product entity
	 * @return the response entity
	 */
	@PostMapping(value = "/createProduct")
	public ResponseEntity<Void> createProduct(@RequestBody ProductEntity productEntity) {
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			this.productService.createProduct(productEntity);
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).build();
	}

	/**
	 * Update the product.
	 *
	 * @param productEntity the product entity
	 * @return the response entity
	 */
	@PostMapping(value = "/updateProduct")
	public ResponseEntity<Void> updateProduct(@RequestBody ProductEntity productEntity) {
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			productEntity.setStatus(HulkStoreConstants.ACTIVE_STATUS);
			this.productService.updateProduct(productEntity);
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).build();
	}

	/**
	 * Update the product.
	 *
	 * @param productEntity the product entity
	 * @return the response entity
	 */
	@PostMapping(value = "/inactivateProduct")
	public ResponseEntity<Void> inactivateProduct(@RequestBody ProductEntity productEntity) {
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			productEntity.setStatus(HulkStoreConstants.INACTIVE_STATUS);
			this.productService.updateProduct(productEntity);
			responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
		} catch (HulkStoreException e) {
			responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
			responseHeaders.set(MES, e.getMessage());
		}
		return ResponseEntity.ok().headers(responseHeaders).build();
	}
}
