package com.Model;

public class Employee {

	private String name = "";
	private int age;
	private int employeeID;
	private String email;
	private String dateOfRegistration;

	public Employee(int employeeID, String name, String email, int age,
			String dateOfRegistration) {
		super();
		this.name = name;
		this.age = age;
		this.employeeID = employeeID;
		this.dateOfRegistration = dateOfRegistration;
		this.email = email;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID
	 *            the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dateOfRegistration
	 */
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	/**
	 * @param dateOfRegistration
	 *            the dateOfRegistration to set
	 */
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", employeeID="
				+ employeeID + ", dateOfRegistration=" + dateOfRegistration
				+ "]";
	}

}