package fr.eni.enchere.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletAjoutArticle
 */
@WebServlet("/ajoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user_id") != null) {
            CategorieManager categorieManager = new CategorieManager();
            UtilisateurManager utilisateurManager = new UtilisateurManager();

            Utilisateur utilisateur = utilisateurManager.getById((int) req.getSession().getAttribute("user_id"));
            ArrayList<Categorie> listeCategories = categorieManager.getAll();

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/base.jsp");
            req.setAttribute("pageAAfficher", "/WEB-INF/ArticleVenduCreation.jsp");
            req.setAttribute("utilisateur", utilisateur);
            req.setAttribute("listeCategories", listeCategories);
            rd.forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/connexion");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategorieManager categorieManager = new CategorieManager();
        UtilisateurManager utilisateurManager = new UtilisateurManager();

        Utilisateur proprietaire = utilisateurManager.getById((int) req.getSession().getAttribute("user_id"));
        Categorie categorie = categorieManager.getById(Integer.parseInt(req.getParameter("categorieId")));

        // Récupération des paramètres de formulaire pour l'article
        String nomArticle = req.getParameter("nomArticle");
        String description = req.getParameter("description");

        Date dateDebutEncheres;
        if (!req.getParameter("dateDebutEncheres").equals("")) {
            dateDebutEncheres = Date.valueOf(req.getParameter("dateDebutEncheres"));
        } else {
            dateDebutEncheres = null;
        }

        Date dateFinEncheres;
        if (!req.getParameter("dateFinEncheres").equals("")) {
            dateFinEncheres = Date.valueOf(req.getParameter("dateFinEncheres"));
        } else {
            dateFinEncheres = null;
        }

        int prixInitial;
        if (!req.getParameter("prixInitial").equals("")) {
            prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        } else {
            prixInitial = 0;
        }

        // Récupération des paramètres de formulaire pour le retrait
        String rue;
        if (req.getParameter("rue").equals("")) {
            rue = proprietaire.getRue();
        } else {
            rue = req.getParameter("rue");
        }

        String codePostal;
        if (req.getParameter("codePostal").equals("")) {
            codePostal = proprietaire.getCodePostal();
        } else {
            codePostal = req.getParameter("codePostal");
        }

        String ville;
        if (req.getParameter("ville").equals("")) {
            ville = proprietaire.getVille();
        } else {
            ville = req.getParameter("ville");
        }

        // Instanciation du nouvel article
        ArticleVenduManager articleVenduManager = new ArticleVenduManager();
        ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, proprietaire, categorie);

        RequestDispatcher rd = null;
        ArticleVendu articleVenduMAJ = null;

        RetraitManager retraitManager = new RetraitManager();

        // Persistance des entités
        try {
            articleVenduMAJ = articleVenduManager.ajouter(articleVendu);
            if (articleVenduMAJ != null) {
                Retrait retrait = new Retrait(articleVenduMAJ.getNoArticle(), rue, codePostal, ville);
                retraitManager.ajouter(retrait);
            }
        } catch (BusinessException e) {
            Utilisateur utilisateur = utilisateurManager.getById((int) req.getSession().getAttribute("user_id"));
            ArrayList<Categorie> listeCategories = categorieManager.getAll();

            rd = req.getRequestDispatcher("/WEB-INF/base.jsp");
            req.setAttribute("error", e.getMessage());
            req.setAttribute("pageAAfficher", "/WEB-INF/ArticleVenduCreation.jsp");
            req.setAttribute("utilisateur", utilisateur);
            req.setAttribute("listeCategories", listeCategories);
            req.setAttribute("nomArticle", req.getParameter("nomArticle"));
            req.setAttribute("description", req.getParameter("description"));
            req.setAttribute("dateDebutEncheres", req.getParameter("dateDebutEncheres"));
            req.setAttribute("dateFinEncheres", req.getParameter("dateFinEncheres"));
            req.setAttribute("prixInitial", req.getParameter("prixInitial"));
            req.setAttribute("categorieId", req.getParameter("categorieId"));
            rd.forward(req, resp);
        }

        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
