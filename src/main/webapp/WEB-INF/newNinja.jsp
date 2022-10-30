<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos And Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
   <h1>New Ninja</h1>
   <form:form class="form" action="/ninjas/create" method="post" modelAttribute="ninja">
		
		<div class="form-group">
			<form:label path="dojo">Select Dojo:</form:label>
			<form:select path = "dojo">
				<c:forEach var="dojo" items="${allDojos}">
				<form:option value="${dojo.id}" path="dojo">
					<c:out value="${dojo.name}"/>
				</form:option>
				</c:forEach>
			</form:select>
		</div> 

   		<div class="form-group row">
	   		<form:label path="firstName">First Name:</form:label>
	   		<form:input path="firstName" class="form-control"/>
	   		<form:errors path="firstName" class="text-danger"/>
   		</div>
   		<div class="form-group row">
	   		<form:label path="lastName">Last Name:</form:label>
	   		<form:input path="lastName" class="form-control"/>
	   		<form:errors path="lastName" class="text-danger"/>
   		</div>
   		   		<div class="form-group row">
	   		<form:label path="age">Age:</form:label>
	   		<form:input path="age" class="form-control"/>
	   		<form:errors path="age" class="text-danger"/>
   		</div>
   		<button class="btn btn-primary">Create</button>
   </form:form>
   </div>
</body>
</html>