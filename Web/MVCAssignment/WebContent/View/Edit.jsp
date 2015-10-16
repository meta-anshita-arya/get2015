<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<header>
	<h1>Edit</h1>
	</header>
	<ul>
		<li><a
			href="http://localhost:8080/MVCAssignment/View/LandingPage.jsp">Landing
				Page</a></li>
		<li><a
			href="http://localhost:8080/MVCAssignment/Register?page=register">Register</a></li>
		<li><a
			href="http://localhost:8080/MVCAssignment/EmployeeList?page=listOfEmployees">List
				Employees</a></li>
	</ul>
	<section> <%
 	String actionOfForm = "";
 	Employee objOfEmployee = null;

 	actionOfForm = "http://localhost:8080/MVCAssignment/UpdateDetailsController";
 	objOfEmployee = (Employee) request.getAttribute("employeeDetails");
 %>
	<center>
		<form action=<%=actionOfForm%> method='get'>
			<table>
				<tr>
					<%
						if (objOfEmployee != null) {
							out.write("<td>Employee ID :</td><td>");
							out.write("<input type='text' readonly='readonly' name='empID' value="
									+ objOfEmployee.getEmployeeID() + ">");
							out.write("</td>");
						}
					%>
				</tr>

				<tr>
					<td>Name :</td>
					<td><input type='text' required name='empName'
						value=<%=(objOfEmployee != null) ? objOfEmployee.getName() : ""%>></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><input type='text' required name='empEmail'
						value=<%=(objOfEmployee != null) ? objOfEmployee.getEmail() : ""%>></td>
				</tr>

				<tr>
					<td>Age :</td>
					<td><input type='text' required name='empAge'
						value=<%=(objOfEmployee != null) ? objOfEmployee.getAge() : ""%>></td>
				</tr>

				<tr>
					<td>Date Of Registration :</td>
					<td><input type='text' required name='empDate'
						value=<%=(objOfEmployee != null) ? objOfEmployee
					.getDateOfRegistration() : ""%>></td>
				</tr>
			</table>
			<br />
			<br />
			<%
				if (objOfEmployee != null)
					out.write("<input type='submit' value='Update' id='updateBtn'/>");
				else
					out.write("<input type='submit' value='Register' id='register' onclick='return validate();'/>");
			%>
		</form>
	</center>
	</section>
</body>
</html>