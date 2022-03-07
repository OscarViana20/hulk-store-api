package com.oviana.hulkstore.common;

import com.oviana.hulkstore.exception.HulkStoreException;

/**
 * The Class HulkStoreConstants.
 */
public final class HulkStoreConstants {
	
	/**
	 * Instantiates a new hulk store constants.
	 */
	private HulkStoreConstants() {
		throw new HulkStoreException("Utility Class");
	}

	public static final String ACTIVE_STATUS = "1";
	
	public static final String INACTIVE_STATUS = "0";
}
