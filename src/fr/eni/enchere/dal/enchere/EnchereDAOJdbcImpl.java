package fr.eni.enchere.dal.enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.ConnectionProvider;

public class EnchereDAOJdbcImpl implements EnchereDAO {

    private static final String INSERT =
            "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_utilisateur, no_article) "
          + "VALUES(?, ?, ?, ?);";

    private static final String UPDATE =
            "UPDATE ENCHERES " +
            "SET " +
                "date_enchere = ?," +
                "montant_enchere = ? " +
            "WHERE no_utilisateur = ? AND no_article = ?;";

    private static final String SELECT =
            "SELECT no_utilisateur, no_article, date_enchere, montant_enchere "
          + "FROM ENCHERES;";

    private static final String GET_BY_ID =
            "SELECT no_utilisateur, no_article, date_enchere, montant_enchere "
          + "FROM ENCHERES "
          + "WHERE no_utilisateur = ? AND no_article = ?;";

    private static final String GET_LATEST_FOR_ARTICLE =
            "SELECT no_utilisateur, no_article, date_enchere, max(montant_enchere) "
                    + "FROM ENCHERES "
                    + "WHERE no_article = ? " +
                        "AND montant_enchere = (SELECT MAX(montant_enchere) " +
                        "                       FROM ENCHERES);";

    @Override
    public void upsert(Enchere enchere) throws BusinessException {

        if(enchere == null) {
            throw new BusinessException();
        }

        try(Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement pStmt = null;

            // INSERT
            if (this.getById(enchere.getUtilisateur().getNoUtilisateur(), enchere.getArticle().getNoArticle()) == null) {
                pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            // UPDATE
            } else {
                pStmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            }
            pStmt.setDate(1, enchere.getDateEnchere());
            pStmt.setInt(2, enchere.getMontantEnchere());
            pStmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
            pStmt.setInt(4, enchere.getArticle().getNoArticle());

            pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException be = new BusinessException();

            throw be;
        }
    }

    @Override
    public Enchere getById(int noUtilisateur, int noArticle) {

        Enchere enchere = null;

        try(Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement pStmt = cnx.prepareStatement(GET_BY_ID);
            pStmt.setInt(1, noUtilisateur);
            pStmt.setInt(2, noArticle);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                enchere = parseResultRow(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return enchere;
    }

    @Override
    public ArrayList<Enchere> getAll() {

        ArrayList<Enchere> listeEncheres = new ArrayList<Enchere>();

        try(Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement pStmt = cnx.prepareStatement(SELECT);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                listeEncheres.add(parseResultRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeEncheres;

    }

    public Enchere getLatestForArticle(int noArticle) {

        Enchere enchere = null;

        try(Connection cnx = ConnectionProvider.getConnection()) {

            PreparedStatement pStmt = cnx.prepareStatement(GET_LATEST_FOR_ARTICLE);
            pStmt.setInt(1, noArticle);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                enchere = parseResultRow(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return enchere;
    }

    private Enchere parseResultRow(ResultSet rs) {

        Enchere enchere = null;

        try {
            UtilisateurManager utilisateurManager = new UtilisateurManager();
            ArticleVenduManager articleManager = new ArticleVenduManager();

            enchere = new Enchere(
                    rs.getDate(3),
                    rs.getInt(4),
                    utilisateurManager.getById(rs.getInt(1)),
                    articleManager.getById(rs.getInt(2))
            );

        } catch(BusinessException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return enchere;
    }
}
