package fr.eni.enchere.dal.categorie;

import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Categorie;

public interface CategorieDAO {
    public Categorie getById(int id) throws BusinessException;
    public List<Categorie> getAll() throws BusinessException;

}
