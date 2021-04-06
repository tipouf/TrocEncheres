package fr.eni.enchere.dal;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
    public void selectById(ArticleVendu articleVendu) throws BusinessException;
    public void selectAll(ArticleVendu articleVendu) throws BusinessException;
    public void insert(ArticleVendu articleVendu) throws BusinessException;
    public void update(ArticleVendu articleVendu) throws BusinessException;
    public void delete(ArticleVendu articleVendu) throws BusinessException;
}
