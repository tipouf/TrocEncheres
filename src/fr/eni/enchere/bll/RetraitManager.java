package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.retrait.RetraitDAO;

public class RetraitManager {

	private RetraitDAO retraitDAO;

	public RetraitManager() {
		retraitDAO = DAOFactory.getRetraitDAO();
	}

	public void ajouter(Retrait retrait) throws BusinessException {

		retraitDAO.insert(retrait);
	}

	public void modifier(Retrait retrait) throws BusinessException {

		retraitDAO.update(retrait);
	}

	public void effacer(Retrait retrait) throws BusinessException {

		retraitDAO.delete(retrait);
	}

	public Retrait SelectParId(int noArticle) throws BusinessException {

		return retraitDAO.getById(noArticle);
	}
}
