<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<spring:url value="/css/style.css" var="urlCss"/>
	<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
	<title>Overzicht voor stadium</title>
</head>
<body>
	<spring:url value="/fifa/" var="showWedstrijdUrl"/>
	<div>
	<h1>FIFA World Cup Qatar 2022</h1>
	<h2>${stadium.name }</h2>
	<table>
		<th>Nr</th>
		<th>Voetbalmatch</th>
		<th>Dag</th>
		<th>Aftrap</th>
		<th>Tickets</th>
		<c:if test="${not empty wedstrijden}">
			<c:forEach items="${wedstrijden}" var="wedstrijden">
				<tr>
					<td><a href="${showWedstrijdUrl}${wedstrijden.wedstrijd.id}">${wedstrijden.wedstrijd.id}</href></td>
					<td>${wedstrijden.wedstrijd.landen[0]} - ${wedstrijden.wedstrijd.landen[1]}</td>
					<td>${wedstrijden.wedstrijd.dag} november</td>
					<td>${wedstrijden.wedstrijd.uur}:00</td>
					<td>${wedstrijden.tickets}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	
		<form action='logout' method='post'>
			<input type="submit" value="Log out"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csfr.token}"/>
		</form>
	
	</div>
</body>
</html>