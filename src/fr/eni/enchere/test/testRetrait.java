package fr.eni.enchere.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Servlet implementation class testRetrait
 */
@WebServlet("/testRetrait")
public class testRetrait extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		RetraitManager retraitManager = new RetraitManager();
//		ArticleVenduManager articleManager = new ArticleVenduManager();
//		Date dateMaintenant= new Date();
//		Date dateFuture=  new Date();
//		dateFuture.setDate(dateFuture.getDate() + 1);
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm");
//
//		ArticleVendu articleVendu = new ArticleVendu("article", "en bon etat", ft.format(dateMaintenant), ft.format(dateFuture), 10, 30,  , categorie)
//		Retrait retrait = new Retrait(1, "test1", "test2", "test3");
//		
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
