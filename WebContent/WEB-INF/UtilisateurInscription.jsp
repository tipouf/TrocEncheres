<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%
    String error = (String) request.getAttribute("error");
%>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <!-- Custom styles for this template -->
    <link href="${context}/css/inscription.css" rel="stylesheet">

<div class="card mt-5">
    <div class="card-header">
        <h1 class="card-title">Créer profil</h1>
    </div>
    <div class="card-body">
        <form action="<%=request.getContextPath()%>/inscription"
              method="post">

            <div class=" form-group row">
                <label for="lastName" class="col-sm-2 col-form-label">Pseudo:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="pseudo"
                           placeholder="Pseudo" required>
                </div>
                <label for="lastName" class="col-sm-2 col-form-label">Nom:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="nom"
                           placeholder="Nom" required>
                </div>
            </div>

            <div class="form-group row mt-2">
                <label for="firstName" class="col-sm-2 col-form-label">Prénom:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="prenom"
                           placeholder="Prénom" required>
                </div>
                <label for="contact" class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" name="email"
                           placeholder="Email" required>
                </div>
            </div>

            <div class="form-group row mt-2">
                <label for="contact" class="col-sm-2 col-form-label">Téléphone:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="telephone"
                           placeholder="Téléphone">
                </div>
                <label for="contact" class="col-sm-2 col-form-label">Rue:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="rue"
                           placeholder="Rue">
                </div>
            </div>

            <div class="form-group row mt-2">
                <label for="lastName" class="col-sm-2 col-form-label">Code
                    postal:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="codePostal"
                           placeholder="Code Postal" required>
                </div>
                <label for="lastName" class="col-sm-2 col-form-label">Ville:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="ville"
                           placeholder="Ville" required>
                </div>
            </div>

            <div class="form-group row mt-2">
                <label for="motdepasse" class="col-sm-2 col-form-label">Mot
                    de passe:</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="motDePasse"
                           placeholder="Mot de passe" required>
                </div>
                <label for="confirmation" class="col-sm-2 col-form-label">Confirmation:</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="confirmation"
                           placeholder="Confirmation du mot de passe" required>
                </div>
            </div>

            <% if (error != null) { %>
            <span class="text-danger"><%= error %></span>
            <% } %>

            <div class="row mt-3">
                <div class="col-6 text-start">
                    <button class="btn btn-danger" onclick="window.location='${pageContext.request.contextPath}/index';return false;">Annuler</button>
                </div>
                <div class="col-6 text-end">
                    <button class="btn btn-info" onclick="window.location='${pageContext.request.contextPath}/connexion';return false;">
                        Se connecter
                    </button>
                    <button type="submit" class="btn btn-primary">
                            Créer
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>