package com.metacube.carportal.exception;

/**
 * @author Anshita
 *
 */
public class CarDekhoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 *            :message of exception
	 */
	public CarDekhoException(String message) {
		super(message);

	}

	/**
	 * @param message
	 *            :message
	 * @param cause
	 *            :cause of exception
	 */
	public CarDekhoException(String message, Throwable cause) {
		super(message, cause);

	}

}
