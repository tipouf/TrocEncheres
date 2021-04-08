package fr.eni.enchere.dal;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.ArticleVendu;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article =?";
	
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
	
	private static final String INSERT_LISTE = "INSERT INTO ARTICLES_VENDUS(nom_article,"
			+ "description,"
			+ "date_debut_encheres,"
			+ "date_fin_encheres,"
			+ "prix_initial,"
			+ "prix_vente,"
			+ "no_utilisateur,"
			+ "no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";

	@Override
	public List<ArticleVendu> selectAll(ArticleVendu articleVendu) throws BusinessException {
		List<ArticleVendu> listes = new ArrayList<ArticleVendu>();

		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);

			while(rs.next()) {
				ArticleVendu nouvelArticle = new ArticleVendu(rs.getInt("noArticle"),
						rs.getString("nomArticle"),
						rs.getString("description"), 
						rs.getDate("date_debut_encheres"),
						rs.getDate("date_debut_fin"),
						rs.getInt("nomArticle"), 
						rs.getInt("nomArticle"));
				listes.add(nouvelArticle);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return listes;
	}

	@Override
	public ArticleVendu selectById(ArticleVendu articleVendu) throws BusinessException {
		List<ArticleVendu> listes = new ArrayList<ArticleVendu>();

		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, articleVendu.getNoArticle());

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				ArticleVendu nouvelArticle = new ArticleVendu(rs.getInt("noArticle"),
						rs.getString("nomArticle"), 
						rs.getString("description"), 
						rs.getDate("date_debut_encheres"),
						rs.getDate("date_debut_fin"),
						rs.getInt("nomArticle"), 
						rs.getInt("nomArticle"));
				listes.add(nouvelArticle);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listes.get(0);
	}

    @Override
    public void insert(ArticleVendu articleVendu) throws BusinessException {
    	try(Connection cnx = ConnectionProvider.getConnection()) {

    		try {
    			PreparedStatement pStmt = cnx.prepareStatement(INSERT_LISTE);
    			pStmt.setString(1, articleVendu.getNomArticle());
    			pStmt.setString(2, articleVendu.getDescription());
    			pStmt.setDate(3, articleVendu.getDateDebutEncheres());
    			pStmt.setDate(4, articleVendu.getDateFinEncheres());
    			pStmt.setInt(5, articleVendu.getPrixInitial());
    			pStmt.setInt(6, articleVendu.getPrixVente());
    			pStmt.setInt(7, articleVendu.());
    			pStmt.setInt(8, articleVendu.getPrixVente());

    			pStmt.executeUpdate();

    			cnx.commit();

    		} catch (SQLException e) {
    			e.printStackTrace();

    			cnx.rollback();
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    @Override
    public void update(ArticleVendu articleVendu) throws BusinessException {

    }

    @Override
    public void delete(ArticleVendu articleVendu) throws BusinessException {
    	try(Connection cnx = ConnectionProvider.getConnection()) {

    		PreparedStatement pStmt = cnx.prepareStatement(DELETE);
    		pStmt.setInt(1, articleVendu.getNoArticle());

    		pStmt.executeUpdate();

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
}
