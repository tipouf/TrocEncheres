package fr.eni.enchere.dal.enchere;

import java.util.ArrayList;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Enchere;

public interface EnchereDAO {
	public ArrayList<Enchere> getAll();
	public Enchere getById(int noUtilisateur, int noArticle);

	public void upsert(Enchere enchere) throws BusinessException;

	public Enchere getLatestForArticle(int noArticle) throws BusinessException;
}
