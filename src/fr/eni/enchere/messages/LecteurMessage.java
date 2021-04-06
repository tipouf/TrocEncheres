package fr.eni.enchere.messages;

import java.util.ResourceBundle;

public class LecteurMessage {

	private static ResourceBundle rb;
	
	//charge le fichier contenant les messages
	static {
		try {
			rb = ResourceBundle.getBundle("fr.eni.enchere.messages.messages_erreur");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMessageErreur(int code) {
		String message = "";
		
		try {
			if(rb != null) {
				message = rb.getString(String.valueOf(code));
			} else {
				message = "Problème lors de la lecture du fichier messages_erreur";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Erreur inconnue";
		}
		
		return message;
	}
	
}
