package fr.eni.enchere.dal;

import fr.eni.enchere.dal.categorie.CategorieDAO;
import fr.eni.enchere.dal.categorie.CategorieDAOJdbcImpl;
import fr.eni.enchere.dal.util.UtilisateurDAO;
import fr.eni.enchere.dal.util.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
}
