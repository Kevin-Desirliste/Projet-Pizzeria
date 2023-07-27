package fr.eni.projetPizza.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Table;
import fr.eni.projetPizza.exception.DALException;

@Component // Ajoutez cette annotation pour indiquer à Spring de créer un bean pour cette classe
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String SELECT_TABLE="SELECT id_table, libelle from TABLE;";
	private static final String SELECT_ENTREE="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'entree';";
	private static final String SELECT_PLAT="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'plat';";
	private static final String SELECT_DESSERT="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'dessert';";
	
	@Override
	public void insert(Article article) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Table> selectTable() throws DALException {
		 List<Table> lstTable = new ArrayList<>();

		    try (Connection cnx = ConnectionProvider.getConnection()) 
		    {
		        PreparedStatement pstmt = cnx.prepareStatement(SELECT_TABLE);
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		        	Table table = new Table(
		            		rs.getInt("id_table"),
		            		rs.getString("libelle")
		            		);
		        	lstTable.add(table);
		    }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return lstTable;
	}
	
}
