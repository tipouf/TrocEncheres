<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Modifier profil</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Bootstrap core CSS -->
<link href="${context}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${context}/css/utilisateurProfil.css" rel="stylesheet">
<%
        String error = (String) request.getAttribute("error");
    %>
</head>
<body>
	<%@include file="entete.jsp"%>
	<div class="container mt-5">
		<div class="container jumbotron marginProfil">
			<div class="card-body">
				<h1 class="display-4 text-left">Mon profil</h1>
				<form action="<%=request.getContextPath()%>/ServletModifierProfil"
					method="post">
					<div class="card-body border">
						<div class="row">

							<label for="pseudo" class="col-sm-2 fw-bold">Pseudo:</label> <input
								class="col-sm-3 col-form-label" type="text" id="pseudoInput"
								name="pseudo" value="${monProfil.pseudo}">
						</div>
						<div class="row">

							<label for="nom" class="col-sm-2 col-form-label fw-bold">Nom:</label>
							<input class="col-sm-3 col-form-label" type="text" id="nomInput"
								name="nom" value="${monProfil.nom}">

						</div>
						<div class="row">

							<label for="prenom" class="col-sm-2 col-form-label fw-bold">Prénom:</label>

							<input class="col-sm-3 col-form-label" type="text"
								id="prenomInput" name="prenom" value="${monProfil.prenom}">

						</div>
						<div class="row">

							<label for="email" class="col-sm-2 col-form-label fw-bold">Email:</label>

							<input class="col-sm-3 col-form-label" type="text"
								id="emailInput" name="email" value="${monProfil.email}">

						</div>
						<div class="row">

							<label for="telephone" class="col-sm-2 col-form-label fw-bold">Téléphone:</label>

							<input class="col-sm-3 col-form-label" type="text"
								id="telephoneInput" name="telephone"
								value="${monProfil.telephone}">

						</div>
						<div class="row">

							<label for="rue" class="col-sm-2 col-form-label fw-bold">Rue:</label>

							<input class="col-sm-3 col-form-label" type="text" id="rueInput"
								name="rue" value="${monProfil.rue}">

						</div>
						<div class="row">

							<label for="codePostal" class="col-sm-2 col-form-label fw-bold">Code
								postal:</label> <input class="col-sm-3 col-form-label" type="text"
								id="codeInput" name="codePostal" value="${monProfil.codePostal}">

						</div>
						<div class="row">

							<label for="ville" class="col-sm-2 col-form-label fw-bold">Ville:</label>


							<input class="col-sm-3 col-form-label" type="text" id="villeInput"
								name="ville" value="${monProfil.ville}">

						</div>
					</div>

					<%
                    if (error != null) {
                %>
					<span class="text-danger"><%=error%></span>
					<%
                    }
                %>
					<div class="bouton text-center mt-3">
						<button type="submit" class="btn btn-danger float-end">Enregistrer</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="${context}/vendor/jquery/jquery.min.js"></script>
	<script src="${context}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
