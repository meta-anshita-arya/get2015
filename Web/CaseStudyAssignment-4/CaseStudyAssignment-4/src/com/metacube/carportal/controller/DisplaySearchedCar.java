package com.metacube.carportal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.db.helper.CarPortalDao;
import com.metacube.carportal.dbconfig.ConnectionFactory;
import com.metacube.carportal.exception.CarDekhoException;
import com.metacube.carportal.model.Car;

/**
 * @ Anshita
 * 
 * Servlet implementation class DisplaySearchedCar
 */
@WebServlet("/display-car")
public class DisplaySearchedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Car> carList = null;
		Connection connection = null;
		// Getting connection
		try {
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}

		} catch (CarDekhoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// search by model and make
		if (request.getParameter("model") != null) {
			// getting carlist for this make and model
			carList = CarPortalDao
					.selectCarBasedOnMakeAndModel(connection,
							request.getParameter("make"),
							request.getParameter("model"));
		}
		// search by price
		else if (Double.parseDouble(request.getParameter("price")) != 0.0) {
			// getting car list for car lower than this budget
			carList = CarPortalDao.selectListOfCarBasedOnBudget(connection,
					Double.parseDouble(request.getParameter("price")));
		}
		// request forwarded to searchcar page to display list of cars
		request.setAttribute("carList", carList);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);

	}
}
