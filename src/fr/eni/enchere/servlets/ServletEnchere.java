package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;

@WebServlet("/enchere/*")
public class ServletEnchere extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// L'utilisateur est-il connecté ?
		if (request.getSession().getAttribute("user_id") == null) {
			request.setAttribute("error", "Vous devez être connecté pour accéder à cette partie du site.");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UtilisateurConnexion.jsp");
			rd.forward(request, response);
		}

		// L'URL est-elle au format /enchere/articleId
		if (request.getPathInfo() == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		}

		int articleId = Integer.parseInt(request.getPathInfo().replace("/", ""));

		ArticleVenduManager articleManager = new ArticleVenduManager();
		RetraitManager retraitManager = new RetraitManager();

		try {
			ArticleVendu article = articleManager.getById(articleId);
			Retrait retrait = retraitManager.getById(articleId);

			request.setAttribute("article", article);
			request.setAttribute("retrait", retrait);

		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/enchere.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
