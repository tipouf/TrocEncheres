<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card mt-5">
    <div class="card-header">
        <h1 class="card-title">
            Ajout d'un article
        </h1>
    </div>
    <div class="card-body">
        <%
            if ((String) request.getAttribute("error") != null) {
        %>
        <div class="alert alert-danger" role="alert">
            <%=((String) request.getAttribute("error")).replaceAll("\n", "<br/>")%>
        </div>
        <%
            }
        %>
        <form action="<%=request.getContextPath()%>/ajoutArticle" method="post">
            <div class="row">
                <div class="col-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="nomArticle">Nom de l'article</span>
                        <input type="text" class="form-control" value="${nomArticle}" name="nomArticle"
                               placeholder="Nom de l'article...">
                    </div>
                </div>
                <div class="col-8">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="description">Description</span>
                        <input class="form-control" value="${description}" name="description"
                               placeholder="Description...">
                    </div>
                </div>
                <div class="col-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="dateDebutEncheres">Date de debut d'encheres</span>
                        <input type="date" value="${dateDebutEncheres}" class="form-control" name="dateDebutEncheres">
                    </div>
                </div>
                <div class="col-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="dateFinEncheres">Date de fin d'encheres</span>
                        <input type="date" value="${dateFinEncheres}" class="form-control" name="dateFinEncheres">
                    </div>
                </div>
                <div class="col-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="prixInitial">Prix initial</span>
                        <input type="number" value="${prixInitial}" class="form-control" name="prixInitial"
                               placeholder="Prix initial(entier)...">
                    </div>
                </div>
                <div class="col-12">
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="inputGroupSelect01">Categorie</label>
                        <select class="form-select" name="categorieId" id="inputGroupSelect01">
                            <c:forEach var="categorie" items="${listeCategories}">
                                <c:choose>
                                    <c:when test="${categorie.noCategorie == categorieId}">
                                        <option value='<c:out value="${categorie.noCategorie}"/>' selected><c:out
                                                value="${categorie.libelle}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value='<c:out value="${categorie.noCategorie}"/>'><c:out
                                                value="${categorie.libelle}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-12">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Adresse de retrait</span>
                        <input type="text" name="rue" value="${utilisateur.rue}" placeholder="${utilisateur.rue}"
                               class="form-control">
                        <input type="number" name="codePostal" value="${utilisateur.codePostal}"
                               placeholder="${utilisateur.codePostal}" class="form-control">
                        <input type="text" name="ville" value="${utilisateur.ville}" placeholder="${utilisateur.ville}"
                               class="form-control">
                    </div>
                </div>
                <div class="col-6 text-start">
                    <button class="btn btn-danger" onclick="window.location='${pageContext.request.contextPath}/index';return false;">Annuler</button>
                </div>
                <div class="col-6 text-end">
                    <button type="submit" class="btn btn-primary">Creer</button>
                </div>
            </div>

        </form>
    </div>
</div>


