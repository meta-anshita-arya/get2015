package com.metacube.carportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.model.Car;
import com.metacube.carportal.service.CarPortalService;

/**
 * @author Anshita
 * 
 *         Servlet implementation class home
 *
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

		// getting list of car
		CarPortalService service = new CarPortalService();
		carList = service.getListOfCarForAdminHome();

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
