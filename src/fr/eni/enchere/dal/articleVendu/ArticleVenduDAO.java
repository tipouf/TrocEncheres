package fr.eni.enchere.dal.articleVendu;

import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
    public ArticleVendu getById(int id) throws BusinessException;
    public List<ArticleVendu> getAll() throws BusinessException;
    public void insert(ArticleVendu articleVendu) throws BusinessException;
    public void update(ArticleVendu articleVendu) throws BusinessException;
    public void delete(ArticleVendu articleVendu) throws BusinessException;
}