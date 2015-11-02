package com.metacube.carportal.exception;

/**
 * @author Anshita
 *
 */
public class CarPortalException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 *            :message of exception
	 */
	public CarPortalException(String message) {
		super(message);

	}

	/**
	 * @param message
	 *            :message
	 * @param cause
	 *            :cause of exception
	 */
	public CarPortalException(String message, Throwable cause) {
		super(message, cause);

	}

}
