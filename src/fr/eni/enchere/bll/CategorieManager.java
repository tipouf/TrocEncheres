package fr.eni.enchere.bll;

import java.util.ArrayList;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.categorie.CategorieDAO;

public class CategorieManager {
    private CategorieDAO categorieDAO;

    public CategorieManager() {
        categorieDAO = DAOFactory.getCategorieDAO();
    }

    public ArrayList<Categorie> getAll() {
        return (ArrayList<Categorie>) categorieDAO.getAll();
    }

    public Categorie getById(int id){
        return categorieDAO.getById(id);
    }

}
