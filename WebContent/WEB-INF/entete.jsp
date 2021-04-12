<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%=session.getAttribute("user_id")%>
<head>
<meta charset="UTF-8">
<title>Entête</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet">
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">

			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index">Enchere ENI</a>

			<c:choose>
				<c:when test="${sessionScope.user_id != null}">
					<a class="ml-auto align-right"
						href="${context}/connexion">Enchères </a>
					<a class="ml-auto align-right"
						href="${context}/vendre">Vendre un
						articles </a>
					<a class="ml-auto align-right"
						href="${context}/monProfil">Mon profil
					</a>
					<a class="ml-auto align-right"
						href="${context}/ServletDeconnexion">Déconnexion
					</a>
				</c:when>
				<c:otherwise>
					<a class="ml-auto align-right"
						href="${context}/connexion">S'incrire
						- Se connecter </a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<% System.out.println( "path = " + request.getServletPath() ); %>
	<% System.out.println( "AbsolutePath = " + request.getServletContext().getRealPath("/") ); %> 
	<% System.out.println ( "CanonicalPath = " +  request.getServletPath().contains("index")); %>

</body>
</html>