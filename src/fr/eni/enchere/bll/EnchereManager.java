package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.enchere.EnchereDAO;
import fr.eni.enchere.bo.Enchere;

import java.util.ArrayList;

public class EnchereManager {

    private EnchereDAO enchereDAO;

    public EnchereManager() {
        enchereDAO = DAOFactory.getEnchereDAO();
    }

    public ArrayList<Enchere> getAll() throws BusinessException {
        return enchereDAO.getAll();
    }

    public void upsert(Enchere enchere) throws BusinessException {
        enchereDAO.upsert(enchere);
    }

    public Enchere getLatestForArticle(int noArticle) throws BusinessException {
        return enchereDAO.getLatestForArticle(noArticle);
    }
}
