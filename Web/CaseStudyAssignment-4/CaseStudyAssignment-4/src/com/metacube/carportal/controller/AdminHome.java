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
 * @author Anshita
 * 
 *         Servlet implementation class home
 */
@WebServlet("/admin-home")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Car> carList = null;
		// getting username and password from request
		String username = request.getParameter("username");
		if (request.getParameter("username") == null) {
			// setting username to session
			HttpSession session = request.getSession(true);
			username = (String) session.getAttribute("username");
		}
		try {// getting connection
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}
			// getting list of all cars
			carList = CarPortalDao.selectListOfCar(connection);

		} catch (CarDekhoException e) {
			e.printStackTrace();
		}
		// Request fowarded to Home page of admin
		request.setAttribute("username", username);
		request.setAttribute("carList", carList);
		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
