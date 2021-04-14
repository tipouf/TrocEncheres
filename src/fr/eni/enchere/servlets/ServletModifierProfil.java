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
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;


@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		HttpSession session = request.getSession(true);    
		int idSession = (int) session.getAttribute("user_id");
		String pseudoSession = (String) session.getAttribute("pseudo");
		String emailSession = (String) session.getAttribute("email");

		
		System.out.println("pseudo " + pseudo);
		System.out.println("pseudoSession " + pseudoSession);
		if (!pseudo.equalsIgnoreCase(pseudoSession) ) {
			if (!utilisateurManager.isPseudoAvailable(pseudo)) {

				error = "Le pseudo existe déjà ";
			}

		} else if (!email.equalsIgnoreCase(emailSession)) {
			if(!utilisateurManager.isEmailAvailable(email)) {
			}
			error = "L'email existe déjà ";
		}

	Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, idSession);
	System.out.println("utilisateur " + utilisateur);
	// Redirige vers la page inscription avec un message d'erreur
	if (error != null) {
		request.setAttribute("error", error);
		request.setAttribute("monProfil", utilisateur);
		rd = request.getRequestDispatcher("/WEB-INF/UtilisateurModifierProfil.jsp");
		rd.forward(request, response);
	}


	try {
		utilisateurManager.modifier(utilisateur);
	} catch (Exception e) {}

	rd = request.getRequestDispatcher("./ServletProfil");
	rd.forward(request, response);
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}
}