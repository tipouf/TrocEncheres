<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<title>Liste des Ventes</title>

<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Bootstrap core CSS -->
<link
	href="${context}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${context}/css/index.css"
	rel="stylesheet">


</head>
<body>

	<!-- Page Features -->
	<div class="container">
		<div class="row text-center">

  
  <c:forEach items="${listeArticles}" var="article">
  			<div class="col-lg-4 col-md-6 mb-4">
  				<button class="card h-100 curseurOnCard" href="${context}/enchere/${article.getNoArticle()}">
					<img class="card-img-top" src="http://placeimg.com/400/400/tech" alt="img">
					<div class="card-body width-center">
						<h4 class="card-title text-center">${article.getNomArticle()}</h4>
						<p class="card-text ml-auto"><div>${article.getPrixVente()}
					</div>
					<div>Fin de l'enchere: <fmt:formatDate value="${article.getDateFinEncheres()}" pattern="dd/MM/yyyy" />
					</div>
					<div>Vendeur: ${article.getProprietaire().getPseudo()}
					</div>
					</div>
				</button>
			</div>
        </c:forEach>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${context}/vendor/jquery/jquery.min.js"></script>
	<script
		src="${context}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>