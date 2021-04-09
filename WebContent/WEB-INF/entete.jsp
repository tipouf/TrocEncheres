<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>Entête</title>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<div class="navbar-brand" href="#">Enchere ENI</div>
			<%
		if (request.getSession().getAttribute("user_id") != null) {
	%>
			<a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/connexion">Enchères <span
				class="sr-only">(current)</span>
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/vendre">Vendre un
				articles <span class="sr-only">(current)</span>
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/monProfil">Mon profil <span
				class="sr-only">(current)</span>
			</a> <a class="ml-auto align-right"
				href="${pageContext.request.contextPath}/déconnexion">Déconnexion
				<span class="sr-only">(current)</span>
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