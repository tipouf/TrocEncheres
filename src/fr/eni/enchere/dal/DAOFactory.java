package fr.eni.enchere.dal;

import fr.eni.enchere.dal.util.UtilisateurDAO;
import fr.eni.enchere.dal.util.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
