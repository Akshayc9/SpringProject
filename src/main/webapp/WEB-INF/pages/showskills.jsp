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

	
	<h1>Skills Information</h1>
	
	<font color="green"><c:out value="${message}"></c:out></font>	
		<a href="/SPMVCMC">HOME</a><br>	<br>
		
	<h1>List of Skills</h1>
      <a href="/SPMVCMC/skill/list"> List of Skills</a>
      <table border="1">
	      <thead>
	      <tr>
			      <th> Skill ID </th>
			      <th> Skill Name </th>
			      <th> Action </th>
	      </tr>
	      </thead>
     	 <c:forEach items="${sklist }" var="sk">
     	 <tr>
     	 <td> ${sk.skId} </td>
     	  <td> ${sk.skName} </td>
     	  
     	   <td>
		   <a href="/SPMVCMC/skill/edit/<c:out value="${sk.skId}"></c:out>">EDIT</a>
		    <a href="/SPMVCMC/skill/delete/<c:out value="${sk.skId}"></c:out>">DELETE</a>
		    
		    </td>
     	  </tr>
     	 </c:forEach>
      </table>
      
      <%--  <form:form method = "POST" action = "/SirSpringMVC/skill/edit/" modelAttribute="skillBean">
         <table>
            <tr>
               <td><form:label path = "skillId">Skill Id to Update: </form:label></td>
               <td><form:input path = "skillId"/></td>
            </tr>
                   <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
      </table>
      </form:form> --%>
</body>
</html>