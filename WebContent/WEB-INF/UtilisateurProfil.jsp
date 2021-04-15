<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!-- Custom styles for this template -->
<link href="${context}/css/utilisateurProfil.css" rel="stylesheet">
<div class="mt-5 card">
    <div class="card-header">
        <h1 class="card-title">Mon profil</h1>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col-2">
                <label for="lastName" class="fw-bold">Pseudo:</label>
            </div>
            <div class="col-8">
                <label for="lastName">${monProfil.pseudo}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="nom" class="fw-bold">Nom:</label>
            </div>
            <div class="col-8">
                <label for="nom">${monProfil.nom}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="prenom" class="fw-bold">Prénom:</label>
            </div>
            <div class="col-8">
                <label for="prenom">${monProfil.prenom}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="email" class="fw-bold">Email:</label>
            </div>
            <div class="col-8">
                <label for="email">${monProfil.email}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="telephone" class="fw-bold">Téléphone:</label>
            </div>
            <div class="col-8">
                <label for="telephone">${monProfil.telephone}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="rue" class="fw-bold">Rue:</label>
            </div>
            <div class="col-8">
                <label for="rue">${monProfil.rue}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="codepostal" class="fw-bold">Code postal:</label>

            </div>
            <div class="col-8">
                <label for="codepostal">${monProfil.codePostal}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="ville" class="fw-bold">Ville:</label>
            </div>
            <div class="col-8">
                <label for="ville">${monProfil.ville}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <label for="lastName" class="fw-bold">Crédit(s):</label>
            </div>
            <div class="col-8">
                <label for="lastName">${monProfil.credit} point(s)</label>
            </div>
        </div>
        <div class="clearfix mt-3 login-buttons">
            <form method="post" action="ServletProfil">
                <button type="submit" value="modify" name="modifier" class="btn btn-primary float-end">
                    Modifier
                </button>
            </form>
        </div>
    </div>
</div>