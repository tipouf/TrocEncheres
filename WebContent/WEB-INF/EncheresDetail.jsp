<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="card mt-5">
    <div class="card-header">
        <h1 class="card-title">
            Détail vente
        </h1>
    </div>

    <div class="card-body">

        <div class="row">
            <span>${article.getNomArticle()}</span>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Description :</span>
            </div>
            <div class="col-8">
                <span>${article.getDescription()}</span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Categorie :</span>
            </div>
            <div class="col-8">
                <span>${article.getCategorie().getLibelle()}</span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Meilleure offre :</span>
            </div>
            <div class="col-8">
                <span>${enchere.getMontantEnchere()} par ${enchere.getUtilisateur().getPseudo()}</span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Mise à  prix :</span>
            </div>
            <div class="col-8">
                <span>${article.getPrixInitial()}</span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Fin de l'enchère :</span>
            </div>
            <div class="col-8">
                <span><fmt:formatDate value="${article.getDateFinEncheres()}" pattern="dd/MM/yyyy" /></span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Retrait :</span>
            </div>
            <div class="col-8">
                <span>${retrait.getRue()}<br/>
                      ${retrait.getCodePostal()} ${retrait.getVille()}
                </span>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <span>Vendeur :</span>
            </div>
            <div class="col-8">
                <span>${article.getProprietaire().getPseudo()}</span>
            </div>
        </div>

        <form action="" method="post">
            Ma proposition :
            <input type="number" name="montant" value="${enchere.getMontantEnchere() + 1}">
            <input type="submit" value="Enchérir">
        </form>



        <div class="row">


        </div>

    </div>

    <% if ((String) request.getAttribute("error") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%=((String) request.getAttribute("error")).replaceAll("\n","<br/>")%>
        </div>
    <% } %>

</div>