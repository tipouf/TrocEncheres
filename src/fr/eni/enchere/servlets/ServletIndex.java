package fr.eni.enchere.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
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
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;

@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategorieManager categorieManager = new CategorieManager();
		ArticleVenduManager articleManager = new ArticleVenduManager();
		try {

			String categorie = request.getParameter("categorie");
			String recherche = request.getParameter("inputRecherche");
			String rechercheWithAccent = "";

			if(categorie == null) {
				categorie = "toutes";
			}

			String categorieWithAccent = new String(categorie.getBytes(),Charset.forName("UTF-8"));

			if(recherche != null) {
				rechercheWithAccent = new String(recherche.getBytes(),Charset.forName("UTF-8"));
			}
			ArrayList<Categorie> listeCategories = categorieManager.getAll()  ;
			request.setAttribute("listeCategories", listeCategories);

			ArrayList<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

			if(categorie.equalsIgnoreCase("toutes") && recherche == null) {
				listeArticles = (ArrayList<ArticleVendu>) articleManager.getAll();
			};

			if(categorie.equalsIgnoreCase("toutes") && recherche != null) {
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParTitre(rechercheWithAccent);
			};

			if(!categorie.equalsIgnoreCase("toutes") && recherche == null){
				int noCategorie = categorieManager.getByLibelle(categorie);
				System.out.println("noCategorie = " + noCategorie);
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParCategorie(noCategorie) ;
			};

			if(!categorie.equalsIgnoreCase("toutes") && recherche != null){
				int noCategorie = categorieManager.getByLibelle(categorieWithAccent);
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParRechercheEtCategorie(rechercheWithAccent, noCategorie) ;
			};

			request.setAttribute("listeArticles", listeArticles);
			request.setAttribute("categorieSelectionnee", categorieWithAccent);
			request.setAttribute("inputRecherche", rechercheWithAccent);

		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
