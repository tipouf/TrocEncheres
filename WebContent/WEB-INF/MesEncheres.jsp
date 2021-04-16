<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />


<div class="card my-4">
	<div class="card-body bg-light-grey">
		<h3>Filtres:</h3>
		<div class="row flex-d">
			<div class="col-xs-8 col-xs-offset-2">
				<form action="./index" method="post">
					<div class="input-group">
						<div class="input-group-btn search-panel">
							<select class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" name="categorie">
								<option value="0">Toutes</option>
								<c:forEach items="${listeCategories}" var="item">
									<option value="${item.noCategorie}"
										${item.noCategorie == categorieSelectionnee ? 'selected="selected"' : ''}>${item.libelle}</option>
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
				<c:if test="${sessionScope.user_id != null}">
							<div class="col">
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
										name="enchereEnCours"> <label>Mes enchères en
										cours</label>
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
										name="enchereRemportees"> <label>Mes enchères
										remportées</label>
								</div>

								<div class="col-4">
									<input type="checkbox" id="venteTerminees"
										name="venteTerminees"> <label>Vente terminées</label>
								</div>
							</div>
						</c:if>
			</div>
		</div>
	</div>
</div>


<%@include file="listeVente.jsp"%>
