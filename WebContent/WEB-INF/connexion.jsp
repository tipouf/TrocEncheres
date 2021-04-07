<!DOCTYPE html>
<html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.enchere.messages.LecteurMessage"%>
<head>

<%
	List<Integer> erreurs = (List<Integer>) request.getAttribute("erreurs");
	if (erreurs != null) {
%>
<h2 style="color: red">Une erreur est survenue !</h2>
<%
	for (int code : erreurs) {
%>
<p><%=LecteurMessage.getMessageErreur(code)%></p>
<%
	}
%>
<%
	}
%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Bienvenue sur Enchere-ENI</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/connexion.css"
	rel="stylesheet">

<%@include file="entete.jsp"%>
</head>
<body>
	<div class="container jumbotron marginConnexion">
		<h1>Page de connexion</h1>
		<div class="card-body">
			<form action="<%=request.getContextPath()%>/ServletConnexion"
				method="post">

				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">Identifiant:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="identifiant" required
							placeholder="Identifiant">
					</div>
					<label for="lastName" class="col-sm-2 col-form-label">Mot
						de passe:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="motDePasse" required
							placeholder="Mot de passe">
					</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-danger btn-default pull-left"
				data-dismiss="modal">
				<span class="glyphicon glyphicon-remove"></span> Connexion
			</button>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit"
			class="container btn btn-danger btn-default pull-left"
			data-dismiss="modal">
			<span class="glyphicon glyphicon-remove"></span><a
				href="${pageContext.request.contextPath}/inscription"
				id="inscription">Créer un compte</a>
		</button>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>