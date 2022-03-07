package com.oviana.hulkstore.repository;

import java.util.Collection;

import com.oviana.hulkstore.entity.PurchaseDetailEntity;
import com.oviana.hulkstore.vo.response.PurchaseDetailResponseVO;

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

	/**
	 * Find detail purchase order.
	 *
	 * @param purchaseId the purchase id
	 * @return the collection
	 */
	Collection<PurchaseDetailResponseVO> findDetailPurchaseOrder(Integer purchaseId);
}
