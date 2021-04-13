package fr.eni.enchere.bo;

import java.sql.Date;

public class ArticleVendu {

    int noArticle;
    String nomArticle;
    String description;
    Date dateDebutEncheres;
    Date dateFinEncheres;
    int prixInitial = 0;
    int prixVente = 0;
    Utilisateur proprietaire;
    Categorie categorie;

    public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
                        Date dateFinEncheres,int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
        super();
        this.noArticle 			= noArticle;
        this.nomArticle 		= nomArticle;
        this.description 		= description;
        this.dateDebutEncheres 	= dateDebutEncheres;
        this.prixInitial 		= prixInitial;
        this.prixVente 			= prixVente;
        this.proprietaire 		= utilisateur;
        this.categorie 			= categorie;
    }

    public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres,
                        Date dateFinEncheres,int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
        super();
        this.nomArticle 		= nomArticle;
        this.description 		= description;
        this.dateDebutEncheres 	= dateDebutEncheres;
        this.prixInitial 		= prixInitial;
        this.prixVente 			= prixVente;
        this.proprietaire 		= utilisateur;
        this.categorie 			= categorie;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getDateFinEncheres() {
        return dateFinEncheres;
    }

    public void setDateFinEncheres(Date dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebutEncheres() {
        return dateDebutEncheres;
    }

    public void setDateDebutEncheres(Date dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }

    public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }
}