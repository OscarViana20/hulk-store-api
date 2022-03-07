package com.oviana.hulkstore.exception;

/**
 * Exception HulkStoreException.
 * 
 * @author oviana
 *
 */
public class HulkStoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with args.
	 * 
	 * @param message The message
	 * @param cause   The cause
	 */
	public HulkStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with args. Personalize exception.
	 * 
	 * @param msg A message for exception
	 */
	public HulkStoreException(String message) {
		super(message);
	}

	/**
	 * Constructor with args.
	 * 
	 * @param cause The cause
	 */
	public HulkStoreException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 */
	public HulkStoreException() {
		super();
	}

}
