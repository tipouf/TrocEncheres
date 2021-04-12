package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<String> categorie = new ArrayList<String>();
		categorie.add("test");
		categorie.add("test2");
		categorie.add("test3");

		ArrayList<String> articles = new ArrayList<String>();
		articles.add("articles1");
		articles.add("articles2");
		articles.add("articles3");
		articles.add("articles4");

		
		request.setAttribute("categorie", categorie);    
		request.setAttribute("articles", articles);   
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
