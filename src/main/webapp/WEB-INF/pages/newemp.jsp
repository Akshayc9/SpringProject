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

	
	<h1>Add New Employee</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	

		<a href="/SPMVCMC">HOME</a><br><br>	<br>
		<br>
	 <form:form method = "POST" action = "/SPMVCMC/employee/save/" modelAttribute="employee">
         <table>            
           <tr>
               <td><form:label path = "empName">Employee Name :</form:label></td>
               <td><form:input path = "empName" /></td>
            </tr>
            
            <tr>
               <td><form:label path = "empAge">Employee Age : </form:label></td>
               <td><form:input path = "empAge" /></td>
            </tr>
            
              <tr>
               <td><form:label path = "empGender">Employee Gender</form:label></td>
               <td>
              		 <form:radiobutton path = "empGender" value="Male"/>Male
               		 <form:radiobutton path = "empGender" value="Female"/>Female
               </td>
            </tr>
             <tr>
               <td><form:label path = "empSalary">Employee Salary</form:label></td>
               <td><form:input path = "empSalary" /></td>
            </tr>
            
                 <tr>
               <td><form:label path = "empAddress">Employee Address</form:label></td>
               <td><form:input path = "empAddress" /></td>
            </tr>
            
          

               <tr>
	               <td><form:label path = "empSkills">Employee Skills</form:label></td>
	                <td>
                <%-- Property is of an array or of type java.util.Collection --%>
                <form:checkboxes path="empSkills" items="${sklist}" itemLabel="skName" itemValue="skName"/>
           		 </td>
	               
<%-- 	               <td>	   
	               <c:forEach items="${sklist}" var="sk"> 
							 		<form:checkbox path="empSkills" value="${sk.skId}"/> ${sk.skName}
							</c:forEach>
					</td> --%>
            </tr> 
             <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form>   
      
      <hr>
      <c:if test="${not empty emplist} }">
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
		
		<c:forEach items="${emplist}" var="cr"> 
		  <tr>
		    <td>${cr.empId}</td>
		    <td>${cr.empName}</td>
		    <td>${cr.empAge}</td>
		      <td>${cr.empGender}</td>
		    <td>${cr.empSalary}</td>
		     <td>${cr.empAddress}</td>
		              <td>	
			<c:forEach var="skill" items="${cr.empSkills}">
					<c:out value="${skill}"></c:out>,
			</c:forEach> </td>
		  </tr>
		</c:forEach>
		</table>  
		</c:if>
</body>
</html>