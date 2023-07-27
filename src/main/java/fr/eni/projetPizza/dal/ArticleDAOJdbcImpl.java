package fr.eni.projetPizza.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.exception.DALException;

@Repository // Ajoutez cette annotation pour indiquer à Spring de créer un bean pour cette classe
public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String SELECT_ARTICLES="SELECT id_article, nom, prix, taille from ARTICLE";
	private static final String SELECT_ENTREE="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'entree'";
	private static final String SELECT_PLAT="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'plat'";
	private static final String SELECT_DESSERT="SELECT id_article, nom, prix, taille, type FROM ARTICLE WHERE type LIKE 'dessert'";
	
	@Autowired
	public ArticleDAOJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	
	
	@Override
	public void insert(Article article) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Article> selectArticles()  {
		List<Article> lstArticles = null;
		try {
			
			 lstArticles = jdbcTemplate.query(SELECT_ARTICLES, new ArticleRowMapper());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
//		 
//		 
//		        PreparedStatement pstmt = cnx.prepareStatement(SELECT_TABLE);
//		        ResultSet rs = pstmt.executeQuery();
//		        while (rs.next()) {
//		        	EtatCommande table = new EtatCommande(
//		            		rs.getInt("id_table"),
//		            		rs.getString("libelle")
//		            		);
//		        	lstTable.add(table);

		    return  lstArticles;
	}
		        
		        
	static class ArticleRowMapper implements RowMapper<Article>{

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Article(rs.getInt("id_article"), rs.getString("nom"), rs.getInt("prix"), rs.getString("taille"));
		}
		
	}
}
