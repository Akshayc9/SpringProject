<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

	
	<h1>List of Employees</h1>	

		<a href="/SPMVCMC">HOME</a><br>
			<font color="green"><c:out value="${message}"></c:out></font>	
		<br>
		<c:if test="${not empty emplist }">
<table border="1">
		<thead>
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			 <th>Employee Gender</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Employee Skills</th>
			<th> Action</th>
		</tr>
		</thead>
		
		<c:forEach items="${emplist}" var="cr"> 
		  <tr>
		    <td>${cr.empId}</td>
		    <td>${cr.empName}</td>
		    <td>${cr.empAge}</td>
		    <td>${cr.empSalary}</td>
		     <td>${cr.empAddress}</td>
 		    <td>${cr.empGender}</td>
	    <td>	
			<c:forEach var="skill" items="${cr.empSkills}">
					<c:out value="${skill.skName}"></c:out>,
			</c:forEach> </td>	
		    <td>
				<a href="/SPMVCMC/employee/update/<c:out value="${cr.empId}"></c:out>">UPDATE</a>
				<a href="/SPMVCMC/employee/delete/<c:out value="${cr.empId}"></c:out>">DELETE</a>
		 	</td> 
		  </tr>
		</c:forEach>
		</table>  
		</c:if>
		
</body>
</html>