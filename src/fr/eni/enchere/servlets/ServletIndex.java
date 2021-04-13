package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DAOFactory;

@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<Categorie> listeCategories = (ArrayList<Categorie>) DAOFactory.getCategorieDAO().getAll();
			ArrayList<ArticleVendu> listeArticles = (ArrayList<ArticleVendu>) DAOFactory.getArticleVenduDAO().getAll();

			request.setAttribute("listeCategories", listeCategories);
			request.setAttribute("listeArticles", listeArticles);

//			System.out.println(listeArticles.get(0).getDateFinEncheres());

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
