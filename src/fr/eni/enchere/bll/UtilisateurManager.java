package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.util.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur ajouter(Utilisateur utilisateur) throws BusinessException {
		
		utilisateurDAO.insert(utilisateur);
		
		return utilisateur;
	}
	
	public boolean isValidUser(String emailOrPseudo, String password) {
		boolean isValidUser = false;
		
		Utilisateur utilisateur = utilisateurDAO.getByEmailOrPseudo(emailOrPseudo);
				
		if (utilisateur != null) {
			
			// Test du mot de passe - A corriger pour tester avec cryptage
			if (password.equals(utilisateur.getMotDePasse())) {
				isValidUser = true;
			}
		}
		
		return isValidUser;
	}
}
