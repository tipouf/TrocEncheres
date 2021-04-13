package fr.eni.enchere.dal.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ConnectionProvider;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT = 
			"INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
					+ "FROM UTILISATEURS;";

	private static final String GET_BY_ID = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
					+ "FROM UTILISATEURS "
					+ "WHERE no_utilisateur = ?;";

	private static final String GET_BY_EMAIL = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
					+ "FROM UTILISATEURS "
					+ "WHERE email LIKE ?;";

	private static final String GET_BY_PSEUDO = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
					+ "FROM UTILISATEURS "
					+ "WHERE pseudo LIKE ?;";

	private static final String GET_BY_EMAIL_OR_PSEUDO = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
					+ "FROM UTILISATEURS "
					+ "WHERE email LIKE ? OR pseudo LIKE ?;";

	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?," +
			"nom = ?," +
			"prenom = ?," +
			"email = ?," +
			"telephone = ?," +
			"rue = ?," +
			"code_postal = ?," +
			"ville = ?," + 
			"WHERE no_utilisateur = ?;";


	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {

		if(utilisateur == null) {
			BusinessException be = new BusinessException();
			//be.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_NULL);
			throw be;
		}

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, utilisateur.getPseudo().toString());
			pStmt.setString(2, utilisateur.getNom().toString());
			pStmt.setString(3, utilisateur.getPrenom().toString());
			pStmt.setString(4, utilisateur.getEmail().toString());
			pStmt.setString(5, utilisateur.getTelephone().toString());
			pStmt.setString(6, utilisateur.getRue().toString());
			pStmt.setString(7, utilisateur.getCodePostal().toString());
			pStmt.setString(8, utilisateur.getVille().toString());
			pStmt.setString(9, utilisateur.getMotDePasse().toString());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();

			throw be;
		}
	}

	@Override
	public ArrayList<Utilisateur> getAll() {

		// Liste des utilisateurs
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				listeUtilisateurs.add(parseResultRow(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listeUtilisateurs;
	}

	@Override
	public Utilisateur getById(int id) {

		Utilisateur utilisateur = null;

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(GET_BY_ID);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				utilisateur = parseResultRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	@Override
	public Utilisateur getByEmail(String email) {

		Utilisateur utilisateur = null;

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(GET_BY_EMAIL);
			pStmt.setString(1, email);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				utilisateur = parseResultRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	@Override
	public Utilisateur getByEmailOrPseudo(String emailOrPseudo) {

		Utilisateur utilisateur = null;

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(GET_BY_EMAIL_OR_PSEUDO);
			pStmt.setString(1, emailOrPseudo);
			pStmt.setString(2, emailOrPseudo);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				utilisateur = parseResultRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	@Override
	public Utilisateur getByPseudo(String pseudo) {

		Utilisateur utilisateur = null;

		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(GET_BY_PSEUDO);
			pStmt.setString(1, pseudo);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				utilisateur = parseResultRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	private Utilisateur parseResultRow(ResultSet rs) {

		Utilisateur utilisateur = null;

		try {

			utilisateur = new Utilisateur(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10),
					rs.getInt(11),
					rs.getBoolean(12)
					);

		} catch(SQLException e) {

		}

		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur)  throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);

			pStmt.setString(1, utilisateur.getPseudo().toString());
			pStmt.setString(2, utilisateur.getNom().toString());
			pStmt.setString(3, utilisateur.getPrenom().toString());
			pStmt.setString(4, utilisateur.getEmail().toString());
			pStmt.setString(5, utilisateur.getTelephone().toString());
			pStmt.setString(6, utilisateur.getRue().toString());
			pStmt.setString(7, utilisateur.getCodePostal().toString());
			pStmt.setString(8, utilisateur.getVille().toString());
			pStmt.setInt(9, utilisateur.getNoUtilisateur());

			pStmt.executeUpdate();

		     
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}

