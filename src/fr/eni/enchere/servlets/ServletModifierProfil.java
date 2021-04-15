package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;


@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String error = null;

		String enregistrer = "enregistrer";

		HttpSession session = request.getSession(true);    
		int idSession = (int) session.getAttribute("user_id");

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = utilisateurManager.getById(idSession);

		String fonction = request.getParameter("fonction");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");


		if (fonction.trim().equalsIgnoreCase(enregistrer.trim())) {
			if (!utilisateur.getPseudo().equalsIgnoreCase(pseudo)) {
				if (!utilisateurManager.isPseudoAvailable(pseudo)) {
					error = "Le pseudo existe déjà";
				} else {
					utilisateur.setPseudo(pseudo);
				}
			}
			if (!utilisateur.getEmail().equalsIgnoreCase(email)) {
				if(!utilisateurManager.isEmailAvailable(email)) {
					error = "L'email existe déjà";
				} else {
					utilisateur.setEmail(email);
				}
			}

			// Redirige vers la page inscription avec un message d'erreur
			if (error != null && fonction.equalsIgnoreCase("enregistrer")) {
				request.setAttribute("error", error);
				request.setAttribute("monProfil", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/UtilisateurModifierProfil.jsp");
				rd.forward(request, response);
			}

			
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);

			try {
				utilisateurManager.update(utilisateur);
			} catch (Exception e) {
				error = "probleme survenu durant l'enregistrement";
			}

			rd = request.getRequestDispatcher("./ServletProfil");
			rd.forward(request, response);

		}


		if (fonction.equalsIgnoreCase("supprimer")) {
			try {
				utilisateurManager.delete(idSession);
			        session.invalidate();
			        response.sendRedirect(request.getContextPath() + "/index");
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}


	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}