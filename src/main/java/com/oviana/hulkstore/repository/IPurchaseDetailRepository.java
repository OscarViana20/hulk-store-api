package com.oviana.hulkstore.repository;

import java.util.Collection;

import com.oviana.hulkstore.entity.PurchaseDetailEntity;

/**
 * The Interface IPurchaseDetailRepository.
 * 
 * @author oviana
 */
public interface IPurchaseDetailRepository {

	/**
	 * Creates the purchase detail.
	 * 
	 * @author oviana
	 *
	 * @param PurchaseDetailCol the purchase detail col
	 */
	void createPurchaseDetail(Collection<PurchaseDetailEntity> PurchaseDetailCol);

	/**
	 * Find purchase detail by user.
	 * 
	 * @author oviana
	 *
	 * @param userName the user name
	 * @return the collection
	 */
	Collection<PurchaseDetailEntity> findPurchaseDetailByUser(String userName);
}
