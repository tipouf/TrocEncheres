<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<div class="d-flex justify-content-center mt-5">
    <img src="${context}/img/logo.png">
</div>

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
                            name="recherche" value="Rechercher"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<%@include file="listeVente.jsp" %>
