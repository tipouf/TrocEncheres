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
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Bootstrap core CSS -->
<link href="${context}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${context}/css/index.css" rel="stylesheet">

<%@include file="entete.jsp"%>
</head>
<body>

	<!-- Page Content -->

	<div class="container">
		<div class="d-flex justify-content-center mt-5">
			<img src="${context}/img/logo.png">
		</div>

		<!-- Jumbotron Header -->
		<div class="jumbotron my-4">

			<div class="container">
				<h3>Filtres:</h3>
				<div class="row flex-d">
					<div class="col-xs-8 col-xs-offset-2">
						<form action="./index" method="post">
							<div class="input-group">
								<div class="input-group-btn search-panel">
									<select class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" name="categorie">
										<option value="toute">Toutes</option>
										<c:forEach items="${listeCategories}" var="item">
											<option value="${item.libelle}"
												${item.libelle == categorieSelectionnee ? 'selected="selected"' : ''}>${item.libelle}</option>
										</c:forEach>
									</select>
								</div>

								<input type="text" class="form-control " name="inputRecherche"
									value="${inputRecherche}"
									placeholder="Le nom de l'article contient"> <input
									type="submit" class="btn btn-primary" id="boutonRecherche"
									name="recherche" value="Rechercher" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="listeVente.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${context}/vendor/jquery/jquery-3.6.0.min.js"></script>
	<script src="${context}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>