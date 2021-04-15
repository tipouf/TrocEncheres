package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.articleVendu.ArticleVenduDAO;

import java.util.ArrayList;
import java.util.List;

public class ArticleVenduManager {
    ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();

    public ArticleVendu ajouter(ArticleVendu articleVendu) throws BusinessException {
        if (!articleVendu.getNomArticle().equals("")
                && !articleVendu.getDescription().equals("")
                && articleVendu.getDateDebutEncheres() != null
                && articleVendu.getDateFinEncheres() != null
                && articleVendu.getCategorie() != null
                && articleVendu.getProprietaire() != null) {

            articleVenduDAO.insert(articleVendu);
        } else {
            String error = "";
            if (articleVendu.getNomArticle().equals("")) {
                error += "Le nom ne peut être nul. \n";
            }
            if (articleVendu.getDescription().equals("")) {
                error += "La description ne peut être nulle. \n";
            }
            if (articleVendu.getDateDebutEncheres() == null) {
                error += "La date de début ne peut être nulle. \n";
            }
            if (articleVendu.getDateFinEncheres() == null) {
                error += "Le date de fin ne peut être nulle. \n";
            }
            if (articleVendu.getCategorie() == null) {
                error += "Le catégorie ne peut être nulle. \n";
            }
            if (articleVendu.getProprietaire() == null) {
                error += "Le propriétaire ne peut être nul. \n";
            }

            throw new BusinessException(error);
        }

        return articleVendu;
    }

    public ArticleVendu modifierPrixVente(ArticleVendu articleVendu, int prixVente) throws BusinessException {
        if (prixVente > articleVendu.getPrixVente()) {
            articleVendu.setPrixVente(prixVente);
            articleVenduDAO.update(articleVendu);
        } else {
            throw new BusinessException();
        }
        return articleVendu;
    }

    public ArrayList<ArticleVendu> getAll() throws BusinessException {

        return (ArrayList<ArticleVendu>) articleVenduDAO.getAll();
    }

    public ArticleVendu getById(int id) throws BusinessException {
        return articleVenduDAO.getById(id);
    }

    public List<ArticleVendu> filtreParTitre(String recherche) {
		return articleVenduDAO.filtreParTitre(recherche);
	}

	public List<ArticleVendu> filtreParCategorie(int noCategorie) {
		return articleVenduDAO.filtreParCategorie(noCategorie);
	}
	
	public List<ArticleVendu> filtreParRechercheEtCategorie(String recherche, int noCategorie) {
		return articleVenduDAO.filtreParRechercheEtCategorie(recherche, noCategorie);
	}
}
