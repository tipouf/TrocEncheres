package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

@WebServlet("/enchere/*")
public class ServletEnchere extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/base.jsp");

        // L'utilisateur est-il connectÃ© ?
        if (request.getSession().getAttribute("user_id") == null) {
            request.setAttribute("error", "Vous devez être connecté pour accéder à  cette partie du site.");
            request.setAttribute("pageAAfficher", "/WEB-INF/UtilisateurConnexion.jsp");
            rd.forward(request, response);
        }

        // L'URL est-elle au format /enchere/articleId
        if (request.getPathInfo() == null) {
            request.setAttribute("pageAAfficher", "/WEB-INF/index.jsp");
            rd.forward(request, response);
        }

        int articleId = Integer.parseInt(request.getPathInfo().replace("/", ""));

        ArticleVenduManager articleManager = new ArticleVenduManager();
        RetraitManager retraitManager = new RetraitManager();
        EnchereManager enchereManager = new EnchereManager();

        try {
            ArticleVendu article = articleManager.getById(articleId);
            Retrait retrait = retraitManager.getById(articleId);
            Enchere enchere = enchereManager.getLatestForArticle(articleId);

            request.setAttribute("article", article);
            request.setAttribute("retrait", retrait);
            request.setAttribute("enchere", enchere);

        } catch (BusinessException e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("pageAAfficher", "/WEB-INF/EncheresDetail.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String error = null;

        // L'utilisateur est-il connecté ?
        if (request.getSession().getAttribute("user_id") == null) {
            request.setAttribute("error", "Vous devez être connecté pour pouvoir enchérir.");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/base.jsp");
            request.setAttribute("pageAAfficher", "/WEB-INF/UtilisateurConnexion.jsp");

            rd.forward(request, response);
        }

        // L'URL est-elle au format /enchere/articleId
        if (request.getPathInfo() == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/base.jsp");
            request.setAttribute("pageAAfficher", "/WEB-INF/index.jsp");

            rd.forward(request, response);
        }

        int articleId = Integer.parseInt(request.getPathInfo().replace("/", ""));
        int userId = (int) request.getSession().getAttribute("user_id");
        int montantEnchere = Integer.parseInt(request.getParameter("montant"));

        UtilisateurManager utilisateurManager = new UtilisateurManager();
        ArticleVenduManager articleManager = new ArticleVenduManager();
        EnchereManager enchereManager = new EnchereManager();

        try {
            Utilisateur utilisateur = utilisateurManager.getById(userId);
            ArticleVendu article = articleManager.getById(articleId);
            Enchere latestEnchere = enchereManager.getLatestForArticle(articleId);

            // L'utilisateur a-t-il suffisement de crÃ©dits pour poser cette enchère ?
            if (utilisateur.getCredit() < montantEnchere) {
                error = "Vous ne disposez pas de suffisamment de crédits pour poser cette enchère.";

            } else if (latestEnchere != null && latestEnchere.getMontantEnchere() > montantEnchere) {
                error = "Vous devez proposer un prix supérieur Ã  l'enchère précédente.";

            // EmpÃªche l'utilisateur d'Ã©nchÃ©rir sur sa propre enchÃ¨re, pour Ã©viter le problÃ¨me du select asynchrone avec l'update
            // Expl : Si l'utilisateur est identique Ã  l'ancien enchÃ©risseur, recrÃ©diter les crÃ©dits (plus bas) va rÃ©cupÃ©rer
            //        l'utilisateur avant que l'update de ses crÃ©dits ne soit terminÃ©, et donc annuler cette opÃ©ration
            } else if (latestEnchere != null && utilisateur.getNoUtilisateur() == latestEnchere.getUtilisateur().getNoUtilisateur()) {
                error = "Vous ne pouvez pas enchérir sur votre propre enchère";

            } else {

                // Création ou update de l'enchère
                Enchere enchere = new Enchere(
                        new java.sql.Date(new Date().getTime()),
                        montantEnchere,
                        utilisateur,
                        article
                );
                new EnchereManager().upsert(enchere);

                // Modification du prix de vente de l'article
                articleManager.modifierPrixVente(article, montantEnchere);

                // Déduction des crédits de l'utilisateur
                utilisateur.setCredit(utilisateur.getCredit() - montantEnchere);
                utilisateurManager.update(utilisateur);

                // Recréditer les crédits au précédent enchérisseur, s'il existe
                if (latestEnchere != null) {
                    Utilisateur latestEncherisseur = latestEnchere.getUtilisateur();
                    latestEncherisseur.setCredit(latestEncherisseur.getCredit() + latestEnchere.getMontantEnchere());
                    utilisateurManager.update(latestEncherisseur);
                }
            }
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/base.jsp");

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("pageAAfficher", "/WEB-INF/EncheresDetail.jsp");
            doGet(request, response);

        } else {
            request.setAttribute("pageAAfficher", "/WEB-INF/index.jsp");
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}