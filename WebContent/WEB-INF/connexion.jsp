<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>

<%
	String error = (String) request.getAttribute("error");
%>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Page de connexion</title>

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
			<h1 class="display-4 text-left">Connexion</h1>
		<div class="card-body">
			<form action="<%=request.getContextPath()%>/connexion" method="post">

				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">Identifiant:</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="identifiant"
							placeholder="Identifiant">
					</div>
					<label for="motDePasse" class="col-sm-2 col-form-label">Mot
						de passe:</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="motDePasse"
							placeholder="Mot de passe">
					</div>

					<%
						if (error != null) {
					%>
					<span class="text-danger"><%=error%></span>
					<%
						}
					%>
				</div>
				<div class="clearfix mt-3 login-buttons">
					<button type="submit" class="btn btn-primary float-end"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span>Connexion
					</button>
					<a class="btn btn-danger float-end"
						href="${pageContext.request.contextPath}/inscription"
						data-dismiss="modal"> Créer un compte </a>
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>