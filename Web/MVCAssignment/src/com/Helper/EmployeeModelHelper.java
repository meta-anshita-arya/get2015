package com.Helper;

import java.util.List;

import com.Model.Employee;

public class EmployeeModelHelper {
	private static EmployeeModelHelper Instance = new EmployeeModelHelper();

	private EmployeeModelHelper() {
		EmployeeCache.addEmployee(new Employee(1, "Anshita", "anshi@gmail.com",
				21, "14/10/2015"));
		EmployeeCache.addEmployee(new Employee(2, "Arushi", "arushi@gmail.com",
				21, "14/10/2015"));
		EmployeeCache.addEmployee(new Employee(3, "Deepali",
				"deepali@gmail.com", 22, "14/10/2015"));
		EmployeeCache.addEmployee(new Employee(4, "Priyamvada",
				"pri@gmail.com", 22, "14/10/2015"));
		EmployeeCache.addEmployee(new Employee(5, "Sumitra",
				"sumitra@gmail.com", 21, "14/10/2015"));
	}

	public static EmployeeModelHelper getInstance() {
		return Instance;
	}

	public static Employee getEmployeeById(int id) {
		return EmployeeCache.getEmployeeById(id);
	}

	public static List<Employee> getAllEmployees() {
		return EmployeeCache.getAllEmployees();

	}

	public static void addEmployee(Employee objEmployeeBean) {
		EmployeeCache.addEmployee(objEmployeeBean);
	}

	public static boolean updateEmployee(Employee objEmployee) {
		return EmployeeCache.updateEmployee(objEmployee);
	}

}
