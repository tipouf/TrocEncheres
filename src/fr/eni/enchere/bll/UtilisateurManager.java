package fr.eni.enchere.bll;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public Utilisateur getByEmailOrPseudo(String emailOrPseudo) {
		return utilisateurDAO.getByEmailOrPseudo(emailOrPseudo);
	}
	
	public boolean isPseudoAvailable(String pseudo) {
		return (utilisateurDAO.getByPseudo(pseudo) == null);
	}
	
	/**
	 * Source : https://stackoverflow.com/a/33085670
	 */
	public String encryptPassword(String password, String salt){
	    String encryptedPassword = null;
	    
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(salt.getBytes(StandardCharsets.UTF_8));
	        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        encryptedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return encryptedPassword;
	}
}
