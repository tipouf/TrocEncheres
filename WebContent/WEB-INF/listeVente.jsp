
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Custom styles for this template -->
<link href="${context}/css/index.css" rel="stylesheet">

<div class="row text-center">
	<c:choose>
		<c:when test="${fn:length(listeArticles) == 0}">
			<div class="alert alert-dark" role="alert">Aucun article ne
				correspond ра votre recherche.</div>
		</c:when>
		<c:otherwise>
			<c:forEach items="${listeArticles}" var="article">
				<div class="col-lg-4 col-md-6 mb-4">
					<a href="${context}/enchere/${article.getNoArticle()}"
						class="text-decoration-none">
						<div class="card">
							<img class="card-img-top" src="http://placeimg.com/400/400/tech"
								alt="img">
							<div class="card-body">
								<h4 class="text-center">${article.getNomArticle()}</h4>
								<div>${article.getPrixVente()} point(s)</div>
								<div>
									Fin de l'enchere:
									<fmt:formatDate value="${article.getDateFinEncheres()}"
										pattern="dd/MM/yyyy" />
								</div>
								<div>Vendeur: ${article.getProprietaire().getPseudo()}</div>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>