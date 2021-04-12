<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>Entête</title>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/entete.css"
	rel="stylesheet">
</head>
<body>

  <% System.out.println( "test = " + pageContext.SESSION ); %>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<div class="navbar-brand" href="#">Enchere ENI</div>
			<%
		if (request.getSession().getAttribute("user_id") != null) {
	%>
			<a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/connexion">Enchères 
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/vendre">Vendre un
				articles 
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/monProfil">Mon profil 
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/déconnexion">Déconnexion
			</a>
			<%
		} else {
	%>
			<a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/connexion">S'incrire -
				Se connecter <span class="sr-only">(current)</span>
			</a>
			<%
		}
	%>
		</div>
	</nav>

</body>
</html>