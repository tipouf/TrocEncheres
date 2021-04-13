package fr.eni.enchere.dal.retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ConnectionProvider;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";

	private static final String GET_BY_ID = "SELECT * FROM RETRAITS WHERE no_article =?";

	private static final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?";

	private static final String UPDATE = "UPDATE RETRAITS SET " +
			"rue = ?," +
			"code_postal = ?," +
			"ville = ?," +
			"WHERE no_article = ? ";


	@Override
	public void insert(Retrait retrait) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			try {
				PreparedStatement pStmt = cnx.prepareStatement(INSERT);
				cnx.setAutoCommit(false);
				pStmt.setInt(1, retrait.getNoArticle());
				pStmt.setString(2, retrait.getRue());
				pStmt.setString(3, retrait.getCodePostal());
				pStmt.setString(4, retrait.getVille());

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
	public Retrait getById(int noArticle) throws BusinessException {
		Retrait retrait = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(GET_BY_ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				retrait = new Retrait(
						rs.getInt("no_article"),
						rs.getString("rue"), 
						rs.getString("code_postal"),
						rs.getString("ville")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return retrait;
	}

	@Override
	public void update(Retrait retrait) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);

			pStmt.setString(1, retrait.getRue());
			pStmt.setString(2, retrait.getCodePostal());
			pStmt.setString(3, retrait.getVille());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Retrait retrait) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, retrait.getNoArticle());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

