package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.articleVendu.ArticleVenduDAO;

public class ArticleVenduManager {
	ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();

	public ArticleVendu ajouter(ArticleVendu articleVendu) throws BusinessException {
		if (!articleVendu.getNomArticle().equals("")
				&& !articleVendu.getDescription().equals("")
				&&  articleVendu.getDateDebutEncheres() != null
				&&  articleVendu.getDateFinEncheres() != null
				&&  articleVendu.getCategorie() != null
				&&  articleVendu.getProprietaire() != null){

			throw new BusinessException();
		}else{
			articleVenduDAO.insert(articleVendu);
		}

		return articleVendu;
	}

	public ArticleVendu modifierPrixVente(ArticleVendu articleVendu, int prixVente) throws BusinessException {
		if (prixVente > articleVendu.getPrixVente()){
			articleVendu.setPrixVente(prixVente);
			articleVenduDAO.update(articleVendu);
		}else{
			throw new BusinessException();
		}
		return articleVendu;
	}

	public List<ArticleVendu> afficherArticles() throws BusinessException {

		return articleVenduDAO.getAll();
	}

	public ArticleVendu getById(int id) throws BusinessException {
		return articleVenduDAO.getById(id);
	}
}
