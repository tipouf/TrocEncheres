package fr.eni.enchere;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErreur;

	public List<Integer> getListeCodesErreur() {
		return listeCodesErreur;
	}
	
	public BusinessException() {
		listeCodesErreur = new ArrayList<Integer>();
	}
	
	public void ajouterErreur(int code) {
		if(!listeCodesErreur.contains(code)) {
			listeCodesErreur.add(code);
		}
	}
	
	public boolean hasErreurs() {
		return listeCodesErreur.size() > 0;
	}
	
}
