<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<spring:url value="/css/style.css" var="urlCss"/>
		<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
		<title>Choose Stadium</title>
	</head>
	
	<body>
		<div>
		<c:if test="${param.gekocht > 0}">
			<div id="message">${param.gekocht} tickets zijn gekocht</div>
		</c:if>
		
		<c:if test="${param.gekocht == 0}">
			<div id="message">Er zijn te weinig tickets beschikbaar</div>
		</c:if>
		<h1>FIFA World Cup Qatar 2022</h1>
		<p>Stadiums:</p>
		<form:form modelAttribute="stadium" method="POST">
			<form:select path="name">
				<form:options items="${stadia}"></form:options>
			</form:select>
			<br/>
			<input type="submit" value="Voer Uit"/>
		</form:form>
		<form action='fifa' method='post'>
			<input type="submit" value="Log out"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csfr.token}"/>
		</form>
		</div>
	</body>
</html>