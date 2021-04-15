<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!-- Custom styles for this template -->
<link href="${context}/css/utilisateurProfil.css" rel="stylesheet">
<%
    String error = (String) request.getAttribute("error");
%>
<div class="card mt-5">
    <div class="card-header">
        <h1 class="card-title">Mon profil</h1>
    </div>
    <div class="card-body">
        <form action="<%=request.getContextPath()%>/ServletModifierProfil"
              method="post">
            <div class="row">
                <div class="col-2">
                    <label for="pseudo" class="fw-bold">Pseudo:</label>
                </div>
                <div class="col-8">
                    <input type="text" id="pseudoInput"
                           name="pseudo" value="${monProfil.pseudo}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="nom" class="fw-bold">Nom:</label>
                </div>
                <div class="col-8">
                    <input type="text" id="nomInput"
                           name="nom" value="${monProfil.nom}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="prenom" class="fw-bold">Prénom:</label>
                </div>
                <div class="col-8">
                    <input type="text"
                           id="prenomInput" name="prenom" value="${monProfil.prenom}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="email" class="fw-bold">Email:</label>
                </div>
                <div class="col-8">
                    <input type="text"
                           id="emailInput" name="email" value="${monProfil.email}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="telephone" class="fw-bold">Téléphone:</label>
                </div>
                <div class="col-8">
                    <input type="text"
                           id="telephoneInput" name="telephone" value="${monProfil.telephone}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="rue" class="fw-bold">Rue:</label>
                </div>
                <div class="col-8">
                    <input type="text" id="rueInput"
                           name="rue" value="${monProfil.rue}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="codePostal" class="fw-bold">Code
                        postal:</label>
                </div>
                <div class="col-8">
                    <input type="text"
                           id="codeInput" name="codePostal" value="${monProfil.codePostal}">
                </div>
            </div>
            <div class="row">
                <div class="col-2">
                    <label for="ville" class="fw-bold">Ville:</label>
                </div>
                <div class="col-8">
                    <input type="text" id="villeInput" name="ville" value="${monProfil.ville}">
                </div>
            </div>
            <%
                if (error != null) {
            %>
            <span class="text-danger"><%=error%></span>
            <%
                }
            %>
            <div class="row mt-3">
                <div class="col-6 text-start">
                    <button type="submit" name="fonction" value="supprimer"
                            class="btn btn-danger">Supprimer
                    </button>
                </div>
                <div class="col-6 text-end">
                    <button class="btn btn-info" onclick="window.location='${pageContext.request.contextPath}/ServletProfil';return false;">
                        Annuler
                    </button>
                    <button type="submit" name="fonction" value="enregistrer" class="btn btn-primary">
                        Enregistrer
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
