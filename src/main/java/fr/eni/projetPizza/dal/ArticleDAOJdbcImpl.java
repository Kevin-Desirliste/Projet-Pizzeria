package fr.eni.projetPizza.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.bo.LigneCommande;
import fr.eni.projetPizza.exception.DALException;


@Repository // Ajoutez cette annotation pour indiquer à Spring de créer un bean pour cette classe
public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String SELECT_ARTICLES="SELECT id_article, nom, prix, taille from ARTICLE";
	private static final String SELECT_ENTREE="SELECT nom, prix from ARTICLE WHERE id_type_article LIKE '1' ";
	private static final String SELECT_PLAT="SELECT nom, prix from ARTICLE WHERE id_type_article LIKE '2' ";
	private static final String SELECT_DESSERT="SELECT nom, prix from ARTICLE WHERE id_type_article LIKE '3' ";
	private static final String INSERT_COMMANDE="INSERT INTO COMMANDE(heure_preparation, total, id_table, id_etat_commande) VALUES(?,?,?,?)";
	private static final String INSERT_LIGNE_COMMANDE="INSERT INTO LIGNE_COMMANDE(id_commande, id_article, quantite) VALUES(?,?,?)";
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
		    return  lstArticles;
	}
	
	@Override
	public List<Article> selectEntree()  {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_ENTREE, new ArticleTypeRowMapper());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		    return  lstArticles;
	}
	
	@Override
	public List<Article> selectPlat()  {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_PLAT, new ArticleTypeRowMapper());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		    return  lstArticles;
	}
	
	@Override
	public List<Article> selectDessert()  {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_DESSERT, new ArticleTypeRowMapper());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		    return  lstArticles;
	}
	
	@Override
	public Object InsertCommande(Commande commande) 
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_COMMANDE);
				
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MINUTE, 20);
				Timestamp DateHeure = new Timestamp(calendar.getTimeInMillis());
				
				//ps.setTimestamp(1, Timestamp.valueOf(commande.getHeureCommande()));
				ps.setTimestamp(1,DateHeure);
				ps.setInt(2, commande.getTotal());
				ps.setInt(3,  commande.getNoTable());
				ps.setInt(4,  commande.getStatutCommande().getidEtatCommande());
				
				return ps;
			}
			
		}, keyHolder);
		
		commande.setIdCommande(keyHolder.getKey().intValue());
		
		return jdbcTemplate.batchUpdate(INSERT_LIGNE_COMMANDE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                // Récupérer la personne de la liste
            	LigneCommande ligne = commande.getLignesCommande().get(i);
            	//id_commande, id_article, quantite
                ps.setInt(1, commande.getIdCommande());
                ps.setInt(2, ligne.getArticle().getIdArticle());
                ps.setInt(3, ligne.getQuantite());
            }

            @Override
            public int getBatchSize() {
                return commande.getLignesCommande().size();
            }
        });
	}
		        
		        
	static class ArticleRowMapper implements RowMapper<Article>{

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Article(rs.getInt("id_article"), rs.getString("nom"), rs.getInt("prix"), rs.getString("taille"));
		}
		
	}
	static class ArticleTypeRowMapper implements RowMapper<Article>{

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Article(rs.getString("nom"), rs.getInt("prix"));
		}
		
	}
}
