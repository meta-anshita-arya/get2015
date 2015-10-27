package com.metacube;

import com.metacube.webServices.TemperatureConvertor;
import com.metacube.webServices.TemperatureConvertorServiceLocator;

// Main class
/**
 * @author Anshita
 *
 */
public class Client {

	public static void main(String[] args) {
		// locator to locate TemperatureConvertor class
		TemperatureConvertorServiceLocator locatorObject = new TemperatureConvertorServiceLocator();
		// locates class via pathway
		locatorObject
				.setTemperatureConvertorEndpointAddress("http://localhost:8080/TempConvertor/services/TemperatureConvertor");

		try {
			// to create object of TemperatureConvertor class
			TemperatureConvertor temperatureConvertorObject = locatorObject
					.getTemperatureConvertor();
			// executing the convertor function and display output
			System.out.println(temperatureConvertorObject.tempConvertor(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
