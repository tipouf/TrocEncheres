package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modification = request.getParameter("modifier");
		System.out.println("modif = " + modification );
		HttpSession session = request.getSession(true);    

		int id = (int) session.getAttribute("user_id");
		UtilisateurManager monprofil = new UtilisateurManager();

		System.out.println(id);

		Utilisateur utilisateur = monprofil.getById(id);

		if (modification == null ) {
			request.setAttribute("monProfil", utilisateur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UtilisateurProfil.jsp");
			rd.forward(request, response);
		} else if (modification.equalsIgnoreCase("modify")){
			request.setAttribute("monProfil", utilisateur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UtilisateurModifierProfil.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
