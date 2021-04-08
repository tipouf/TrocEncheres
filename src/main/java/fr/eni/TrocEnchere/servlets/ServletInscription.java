package fr.eni.TrocEnchere.servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TrocEnchere.bll.UtilisateurManager;
import fr.eni.TrocEnchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SALT = "salt";

	/**
	 * Page d'inscription à l'application
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * Tentative d'inscription d'un nouvel utilisateur
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("motDePasse");
		String confirmPassword = request.getParameter("confirmationMotDePasse");

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		RequestDispatcher rd = null;
		
		if (utilisateurManager.isPseudoAvailable(pseudo)) {
			
			String encryptedPassword = utilisateurManager.encryptPassword(password);
			
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, encryptedPassword, 100, false);
			
			try {
				utilisateurManager.ajouter(utilisateur);
			} catch(Exception e) {}
			
			 rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");

		} else {
			request.setAttribute("error", "Le pseudo existe déjà");
			rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		}
		
		rd.forward(request, response);
	}
}
