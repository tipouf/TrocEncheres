package fr.eni.enchere.dal.categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.ConnectionProvider;

public class CategorieDAOJdbcImpl implements CategorieDAO {

    private static final String GET_ALL = "SELECT * FROM CATEGORIES";

    private static final String GET_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie =?";
    
    private static final String GET_BY_LIBELLE = "SELECT * FROM CATEGORIES WHERE libelle =?";

    @Override
    public Categorie getById(int id){
        List<Categorie> listes = new ArrayList<>();

        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(GET_BY_ID);
            pStmt.setInt(1, id);

            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
                Categorie nouvelleCategorie = new Categorie(rs.getInt("no_categorie"),
                        rs.getString("libelle"));
                listes.add(nouvelleCategorie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listes.get(0);
    }

    @Override
    public List<Categorie> getAll(){
        List<Categorie> listes = new ArrayList<>();

        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(GET_ALL);

            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
                Categorie nouvelleCategorie = new Categorie(rs.getInt("no_categorie"),
                        rs.getString("libelle"));
                listes.add(nouvelleCategorie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listes;
    }

	@Override
	public int getByLibelle(String libelle) {
		  int noCategorie = 0;
		  
	        try(Connection cnx = ConnectionProvider.getConnection()) {
	            PreparedStatement pStmt = cnx.prepareStatement(GET_BY_LIBELLE);
	            pStmt.setString(1, libelle);

	            ResultSet rs = pStmt.executeQuery();

	            while(rs.next()) {
	                noCategorie = rs.getInt("no_categorie");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return noCategorie;
	    }
	}
