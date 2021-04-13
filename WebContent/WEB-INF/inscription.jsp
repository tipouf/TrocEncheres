<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.enchere.messages.LecteurMessage"%>
<%@ page session="false"%>
<%@page import="java.util.List"%>

<%
	String error = (String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Bootstrap core CSS -->
<link href="${context}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${context}/css/inscription.css" rel="stylesheet">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">

			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index">Enchere ENI</a>
		</div>
	</nav>
</head>
<body>
	<div class="container jumbotron marginInscription">
		<h1 class="display-4 text-left">Créer profil</h1>
		<div class="card-body">
			<form action="<%=request.getContextPath()%>/inscription"
				method="post">

				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">Pseudo:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="pseudo"
							placeholder="Pseudo" required>
					</div>
					<label for="lastName" class="col-sm-2 col-form-label">Nom:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="nom"
							placeholder="Nom" required>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label for="firstName" class="col-sm-2 col-form-label">Prénom:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="prenom"
							placeholder="Prénom" required>
					</div>
					<label for="contact" class="col-sm-2 col-form-label">Email:</label>
					<div class="col-sm-4">
						<input type="email" class="form-control" name="email"
							placeholder="Email" required>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label for="contact" class="col-sm-2 col-form-label">Téléphone:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="telephone"
							placeholder="Téléphone">
					</div>
					<label for="contact" class="col-sm-2 col-form-label">Rue:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="rue"
							placeholder="Rue">
					</div>
				</div>

				<div class="form-group row mt-2">
					<label for="lastName" class="col-sm-2 col-form-label">Code
						postal:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="codePostal"
							placeholder="Code Postal" required>
					</div>
					<label for="lastName" class="col-sm-2 col-form-label">Ville:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="ville"
							placeholder="Ville" required>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label for="motdepasse" class="col-sm-2 col-form-label">Mot
						de passe:</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="motDePasse"
							placeholder="Mot de passe" required>
					</div>
					<label for="confirmation" class="col-sm-2 col-form-label">Confirmation:</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="confirmation"
							placeholder="Confirmation du mot de passe" required>
					</div>
				</div>

				<% if(error != null) { %>
				<span class="text-danger"><%= error %></span>
				<% } %>

				<div class="bouton text-center mt-3">
					<button type="submit" class="btn btn-primary">Créer</button>
				</div>
			</form>
			<button class="btn btn-primary"
				onclick="${pageContext.request.contextPath}/login">Annuler</button>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="${context}/vendor/jquery/jquery.min.js"></script>
	<script src="${context}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>