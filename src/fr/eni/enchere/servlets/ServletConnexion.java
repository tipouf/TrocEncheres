package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/login")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SALT = "salt";

	/**
	 * Page affichée lorsque l'utilisateur n'est pas connecté à l'appli
	 * Page par défaut
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * Tentative de connexion de l'utilisateur
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailOrPseudo = request.getParameter("emailOrPseudo");
		String password = request.getParameter("password");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = utilisateurManager.getByEmailOrPseudo(emailOrPseudo);
					
		RequestDispatcher rd = null;
		
		if (utilisateur != null) {
														
			// Test du mot de passe
			if (utilisateurManager.encryptPassword(password, SALT).equals(utilisateur.getMotDePasse())) {
				
				// Ajout d'une variable de session "user_id" pour autoriser l'accès aux autres pages du site
				request.getSession().setAttribute("user_id", utilisateurManager.getByEmailOrPseudo(emailOrPseudo).getNoUtilisateur());
				
				rd = request.getRequestDispatcher("/views/home.jsp");		
				
			} else {
				rd = request.getRequestDispatcher("/views/login.jsp");
				request.setAttribute("error", "Mot de passe incorrect");
			}

		} else {
			rd = request.getRequestDispatcher("/views/login.jsp");
			request.setAttribute("error", "Utilisateur incorrect");
		}

		rd.forward(request, response);
	}
}
