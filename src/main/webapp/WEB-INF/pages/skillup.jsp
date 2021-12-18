<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skill Details</title>
</head>
<body>

	
	<h1>Add New Skill</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		<a href="/SPMVCMC">HOME</a><br>	<br>
		
	 <form:form method = "POST" action = "/SPMVCMC/skill/edit/" modelAttribute="skill">
         <table>
            <tr>
               <td><form:label path = "skId">Skill Id : </form:label></td>
               <td><form:input path = "skId" readonly="true" /></td>
            </tr>
            
           <tr>
               <td><form:label path = "skName">Skill Name :</form:label></td>
               <td><form:input path = "skName" /></td>
            </tr>
            
             <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form> 
      
</body>
</html>