<%@page import="com.Model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%
		List<Employee> list1 = (List<Employee>) request
				.getAttribute("employeeList");

		out.print("List Of Employees ");
		out.write("<br><br>");
		for (Employee str : list1) {
			out.print(str.getName());
			out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.write("<a href='http://localhost:8080/MVCAssignment/ViewDetailController?id="
					+ str.getEmployeeID() + "'> View details</a>");
			out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.write("<a href='http://localhost:8080/MVCAssignment/EditDetailController?id="
					+ str.getEmployeeID() + "'> Edit details </a>");
			out.write("<br>");
		}
	%>

</body>

</html>