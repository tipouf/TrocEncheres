package fr.eni.enchere.dal.articleVendu;

import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;

public interface ArticleVenduDAO {
    public ArticleVendu getById(int id) throws BusinessException;
    public List<ArticleVendu> getAll() throws BusinessException;
    public void insert(ArticleVendu articleVendu) throws BusinessException;
    public void update(ArticleVendu articleVendu) throws BusinessException;
    public void delete(ArticleVendu articleVendu) throws BusinessException;
    public List<ArticleVendu> filtreParCategorie(int noCategorie);
    public List<ArticleVendu> filtreParTitre(String recherche);
	public List<ArticleVendu> filtreParRechercheEtCategorie(String recherche, int noCategorie);
}