package fr.eni.enchere.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;


/**
 * Servlet implementation class ServletAjoutArticle
 */
@WebServlet("/ajoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/UtilisateurConnexion.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomArticle = req.getParameter("nomArticle");
        String description = req.getParameter("description");
        Date dateDebutEncheres = Date.valueOf(req.getParameter("dateDebutEncheres"));
        Date dateFinEncheres = Date.valueOf(req.getParameter("dateFinEncheres"));
        int prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        int prixVente = Integer.parseInt(req.getParameter("prixVente"));
        Utilisateur proprietaire = DAOFactory.getUtilisateurDAO().getById(Integer.parseInt(req.getParameter("proprietaireId")));

		try {
			categorie = DAOFactory.getCategorieDAO().getById(Integer.parseInt(req.getParameter("categorieId")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ArticleVenduManager articleVenduManager = new ArticleVenduManager();
        ArticleVendu articleVendu = new ArticleVendu(nomArticle,description,dateDebutEncheres,dateFinEncheres,prixInitial,prixVente,proprietaire,categorie);

        try {
            articleVenduManager.ajouter(articleVendu);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("./index");
    }
}
