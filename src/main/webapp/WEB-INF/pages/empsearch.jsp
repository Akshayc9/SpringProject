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

	
	<h1>Search Employee</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	

		<a href="/SPMVCMC">HOME</a><br><br>	<br>
		<br>
	 <form:form method = "POST" action = "/SPMVCMC/employee/search/" modelAttribute="employee">
         <table>            
           <tr>
               <td><form:label path = "empId">Enter Employee ID :</form:label></td>
               <td><form:input path = "empId" /></td>
            </tr>
            
             <tr>
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form>   
      
      <hr>
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
		</tr>
		</thead>
		
		  <tr>
		    <td>${employee.empId}</td>
		    <td>${employee.empName}</td>
		    <td>${employee.empAge}</td>
		     <td>${employee.empGender}</td>
		    <td>${employee.empSalary}</td>
		     <td>${employee.empAddress}</td>
		         <td>	
			<c:forEach var="skill" items="${employee.empSkills}">
					<c:out value="${skill}"></c:out>,
			</c:forEach> </td>
		  </tr>
		</table>  
</body>
</html>