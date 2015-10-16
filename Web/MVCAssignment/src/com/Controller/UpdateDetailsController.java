package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Helper.EmployeeModelHelper;
import com.Model.Employee;

/**
 * Servlet implementation class UpdateDetailsController
 */
@WebServlet("/UpdateDetailsController")
public class UpdateDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee objEmployee = new Employee();
		objEmployee.setEmployeeID(Integer.parseInt(request
				.getParameter("empID")));
		objEmployee.setName(request.getParameter("empName"));
		objEmployee.setEmail(request.getParameter("empEmail"));
		objEmployee.setAge(Integer.parseInt(request.getParameter("empAge")));
		objEmployee.setDateOfRegistration(request.getParameter("empDate"));
		boolean result = EmployeeModelHelper.updateEmployee(objEmployee);
		if (result) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/EmployeeList");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Error");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
