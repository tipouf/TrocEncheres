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

@WebServlet("/mesEncheres")
public class ServletMesEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategorieManager categorieManager = new CategorieManager();
		ArticleVenduManager articleManager = new ArticleVenduManager();

			String categorie = request.getParameter("categorie");
			String recherche = request.getParameter("inputRecherche");
			String rechercheWithAccent = "";
			Boolean rechercheVide = true;

			// selection de la categorie "toutes" par defaut
			if(categorie == null) {
				categorie = "0";
			}
			
			//conversion de la String categorie récupéré en entier
			int noCategorie= Integer.parseInt(categorie);
			
			if(recherche == "" || recherche == null) {
				rechercheVide = true;
			} else {
				rechercheVide = false;
			}
	
			if(recherche != null) {
				rechercheWithAccent = new String(recherche.getBytes(),Charset.forName("UTF-8"));
			}

			ArrayList<Categorie> listeCategories = categorieManager.getAll()  ;
			request.setAttribute("listeCategories", listeCategories);

			ArrayList<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

			//affichage de la liste sans filtre
			if(noCategorie == 0 && rechercheVide) {
				try {
					listeArticles = (ArrayList<ArticleVendu>) articleManager.getAll();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};

			//affichage de la liste avec un filtre sur le champ de recherche
			if(noCategorie == 0  && !rechercheVide) {
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParTitre(rechercheWithAccent);
			};

			//affichage de la liste avec un filtre seulement sur la categorie
			if(noCategorie !=0 && rechercheVide){
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParCategorie(noCategorie) ;
			};

			//affichage de la liste vide avec filtre sur categorie et champ de recherche
			if(noCategorie !=0 && !rechercheVide){
				listeArticles = (ArrayList<ArticleVendu>) articleManager.filtreParRechercheEtCategorie(rechercheWithAccent, noCategorie) ;
			};

			request.setAttribute("listeArticles", listeArticles);
			request.setAttribute("categorieSelectionnee", noCategorie);
			request.setAttribute("inputRecherche", rechercheWithAccent);


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/base.jsp");
		request.setAttribute("pageAAfficher", "/WEB-INF/MesEncheres.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
