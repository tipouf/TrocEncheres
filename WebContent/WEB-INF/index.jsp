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
											<option value="toute">Toutes</option>
											<c:forEach items="${listeCategories}" var="item">
												<option value="${item.libelle}">${item.libelle}</option>
											</c:forEach>
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

								<c:if test="${sessionScope.user_id != null}">
									<div class="row">
										<div class="col-4 mt-2">
											<input checked class="form-check-input " type="radio"
												id="achat" name="selectionFiltreAchats"> <label>Mes
												achats</label>
										</div>
										<div class="col-4 mt-2">
											<input class="form-check-input " type="radio" id="ventes"
												name="selectionFiltreVentes"> <label>Mes
												ventes</label>
										</div>
									</div>
									<div class="row">
										<div class="col-4">
											<input type="checkbox" id="encheresOuvertes"
												name="enchereOuvertes"> <label>Encheres
												ouvertes</label>
										</div>

										<div class="col-4">
											<input type="checkbox" id="ventesEnCours" name="venteEnCours">
											<label>Mes ventes en cours</label>
										</div>
									</div>
									<div class="row">
										<div class="col-4">
											<input type="checkbox" id="EncheresEncours"
												name="enchereEnCours"> <label>Mes enchères
												en cours</label>
										</div>

										<div class="col-4">
											<input type="checkbox" id="venteNonDebutees"
												name="ventesNonDebutées"> <label>Ventes non
												débutées</label>
										</div>
									</div>
									<div class="row">
										<div class="col-4">
											<input type="checkbox" id="encheresRemportees"
												name="enchereRemportees"> <label>Mes
												enchères remportées</label>
										</div>

										<div class="col-4">
											<input type="checkbox" id="venteTerminees"
												name="venteTerminees"> <label>Vente
												terminées</label>
										</div>
									</div>
								</c:if>
							</form>
						</div>
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