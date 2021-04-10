package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SALT = "salt";

	/**
	 * Page d'inscription Ã  l'application
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * Tentative d'inscription d'un nouvel utilisateur
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;
		String error = null;

		UtilisateurManager utilisateurManager = new UtilisateurManager();

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("motDePasse");
		String confirmPassword = request.getParameter("confirmation");

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher matcher = pattern.matcher(password);

		if (!password.equals(confirmPassword)) {
			error = "Les mots de passe ne correspondent pas";

		} else if (!utilisateurManager.isPseudoAvailable(pseudo)) {
			error = "Le pseudo existe déjà ";

		} else if (!utilisateurManager.isEmailAvailable(email)) {
			error = "L'email existe déjà ";

		} else if (!matcher.matches()) {
			error = "Le mot de passe ne doit contenir que des caractères alphanumériques";
		}

		// Redirige vers la page inscription avec un message d'erreur
		if (error != null) {
			request.setAttribute("error", error);
			rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			rd.forward(request, response);
		}

		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, utilisateurManager.encryptPassword(password), 100, false);

		try {
			utilisateurManager.ajouter(utilisateur);
		} catch (Exception e) {}

		rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	}
}
