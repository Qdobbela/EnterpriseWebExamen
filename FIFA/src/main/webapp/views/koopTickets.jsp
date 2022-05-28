<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<spring:url value="/css/style.css" var="urlCss"/>
	<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
	<title>Tickets Kopen</title>
</head>
<body>
	<div>
		<h1>FIFA World Cup Qatar 2022</h1>
		<h3>Wedstrijd: ${wedstrijd.wedstrijd.landen[0] } - ${ wedstrijd.wedstrijd.landen[1]} op ${wedstrijd.wedstrijd.dag }-11</h3>
		<h3>Tickets beschikbaar: ${wedstrijd.tickets }</h3>
		
		<form:form method="POST" modelAttribute="aankoop">
			<table>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="aantal">Aantal tickets:</form:label></td>
                    <td><form:input path="aantal" value="10"/></td>
                    <td><form:errors path="aantal" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="voetbalcode1">Voetbalcode 1:</form:label></td>
                    <td><form:input path="voetbalcode1" value="11"/></td>
                    <td><form:errors path="voetbalcode1" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="voetbalcode2">Voetbalcode 2:</form:label></td>
                    <td><form:input path="voetbalcode2" value="22"/></td>
                    <td><form:errors path="voetbalcode2" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Koop"/></td>
                </tr>
            </table>
		</form:form>
		
	</div>
</body>
</html>