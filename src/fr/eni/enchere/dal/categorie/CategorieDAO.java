package fr.eni.enchere.dal.categorie;

import java.util.List;

import fr.eni.enchere.bo.Categorie;

public interface CategorieDAO {
    public Categorie getById(int id);
    public List<Categorie> getAll();
}
