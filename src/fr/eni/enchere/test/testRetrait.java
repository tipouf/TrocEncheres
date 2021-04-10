package fr.eni.enchere.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bo.Retrait;

/**
 * Servlet implementation class testRetrait
 */
@WebServlet("/testRetrait")
public class testRetrait extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RetraitManager retraitManager = new RetraitManager();
		Retrait retrait = new Retrait(1, "test1", "test2", "test3");
		
		try {
			retraitManager.ajouter(retrait);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
