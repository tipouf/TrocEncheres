package fr.eni.enchere.bo;

import java.time.LocalDateTime;

public class Enchere {

	private int noEnchere;
	private LocalDateTime dateEnchere;
	private float montantEnchere;
	
	public Enchere(LocalDateTime dateEnchere, float montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public float getMontant_enchere() {
		return montantEnchere;
	}

	public void setMontant_enchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere="
				+ montantEnchere + "]";
	}	
}
