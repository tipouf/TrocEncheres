<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Mon Profil</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Bootstrap core CSS -->
<link href="${context}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${context}/css/utilisateurProfil.css" rel="stylesheet">
</head>
<body>
	<%@include file="entete.jsp"%>
	<div class="container mt-5">
		<div class="container jumbotron marginProfil">
			<div class="card-body">
				<h1 class="display-4 text-left">Mon profil</h1>
				<div class="card-body border">

					<div class="row">

						<label for="lastName" class="col-sm-2 fw-bold"">Pseudo:</label> <label
							for="lastName" class="col-sm-2 col-form-label">${monProfil.pseudo}</label>
					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold"">Nom:</label>

						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.nom}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Prénom:</label>


						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.prenom}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Email:</label>


						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.email}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Téléphone:</label>

						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.telephone}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Rue:</label>

						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.rue}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Code
							postal:</label> <label for="lastName" class="col-sm-2 col-form-label">${monProfil.codePostal}</label>

					</div>
					<div class="row">

						<label for="lastName" class="col-sm-2 col-form-label fw-bold">Ville:</label>


						<label for="lastName" class="col-sm-2 col-form-label">${monProfil.ville}</label>

					</div>
				</div>
				<div class="clearfix mt-3 login-buttons">
					<form method="post" action="ServletProfil">
						<button type="submit" value="modify" name="modifier" class="btn btn-primary float-end">
							Modifier
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="${context}/vendor/jquery/jquery.min.js"></script>
	<script src="${context}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
