package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Anshita
 *
 */
@WebService
public class ConvertUnits {
	// function to convert fahrenheit into celsiusF
	@WebMethod
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit * (9 / 5.0) + 32);
	}
}
