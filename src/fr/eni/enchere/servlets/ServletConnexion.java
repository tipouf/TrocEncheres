package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/login")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailOrPseudo = request.getParameter("emailOrPseudo");
		String password = request.getParameter("password");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		boolean isValidUser = utilisateurManager.isValidUser(emailOrPseudo, password);
					
		RequestDispatcher rd = null;
		
		if (isValidUser) {
			rd = request.getRequestDispatcher("/views/home.jsp");
		} else {
			rd = request.getRequestDispatcher("/views/login.jsp");
			request.setAttribute("error", "Utilisateur incorrect");
		}

		rd.forward(request, response);
	}

}
