<!DOCTYPE html>
<html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>

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
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet">

<%@include file="entete.jsp"%>
</head>
<body>


	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<div class="jumbotron my-4">
			<h1 class="display-3 text-center">Liste des enchères</h1>
			<div class="col-md-9 col-md-push-1 ">

				<div class="container">
					<h3>Filtres:</h3>
					<div class="row flex-d">
						<div class="col-xs-8 col-xs-offset-2">
							<form action="./rechercheVente" method="post">
								<div class="input-group">
									<div class="input-group-btn search-panel">
										<select class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											<option>Toutes</option>
											<option>Informatique</option>
											<option>Ameublement</option>
											<option>Vêtement</option>
											<option>Sport&Loisirs</option>
										</select>
									</div>

									<input type="text" class="form-control " name="x"
										placeholder="Le nom de l'article contient"> <span
										class="input-group-btn">
										<button class="btn btn-default " type="button">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span> <a href="#" class="btn btn-primary btn-lg">Rechercher</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="listeVente.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/jquery/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>