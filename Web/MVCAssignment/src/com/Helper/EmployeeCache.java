package com.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.Model.Employee;

public class EmployeeCache {

	private static ConcurrentHashMap<Integer, Employee> empMap = new ConcurrentHashMap<Integer, Employee>();

	// private static EmployeeCache Instance = new EmployeeCache();
	//
	// private EmployeeCache()
	// {
	// }
	//
	// public static EmployeeCache getInstance()
	// {
	// return Instance;
	// }

	public static Employee getEmployeeById(int id) {
		return empMap.get(id);
	}

	public static List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(empMap.values());

	}

	public static void addEmployee(Employee objEmployee) {
		objEmployee.setEmployeeID(empMap.size() + 1);
		empMap.put(objEmployee.getEmployeeID(), objEmployee);

	}

	public static boolean updateEmployee(Employee objEmployee) {
		if (empMap.containsKey(objEmployee.getEmployeeID())) {
			empMap.replace(objEmployee.getEmployeeID(), objEmployee);
			return true;
		} else {
			return false;
		}
	}

}
