package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.categorie.CategorieDAO;

import java.util.ArrayList;

public class CategorieManager {
    private CategorieDAO categorieDAO;

    public CategorieManager() {
        categorieDAO = DAOFactory.getCategorieDAO();
    }

    public ArrayList<Categorie> getAll() throws BusinessException {
        return (ArrayList<Categorie>) categorieDAO.getAll();
    }

    public Categorie getById(int id) throws BusinessException {
        return categorieDAO.getById(id);
    }
}
