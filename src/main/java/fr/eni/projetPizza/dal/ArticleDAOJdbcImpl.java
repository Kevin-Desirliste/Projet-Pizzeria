package fr.eni.projetPizza.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.bo.EtatCommande;
import fr.eni.projetPizza.bo.LigneCommande;
import fr.eni.projetPizza.exception.DALException;

@Repository // Ajoutez cette annotation pour indiquer à Spring de créer un bean pour cette
			// classe
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;

	private static final String SELECT_ARTICLES = "SELECT id_article, nom, prix, taille from ARTICLE";
	private static final String SELECT_ARTICLES_BY_ID = "SELECT id_article, nom, prix, taille FROM ARTICLE WHERE id_article = :idArticle";
	private static final String SELECT_ENTREE = "SELECT id_article, nom, prix from ARTICLE WHERE id_type_article LIKE '1' ";
	private static final String SELECT_PLAT = "SELECT id_article, nom, prix from ARTICLE WHERE id_type_article LIKE '2' ";
	private static final String SELECT_DESSERT = "SELECT id_article, nom, prix from ARTICLE WHERE id_type_article LIKE '3' ";
	private static final String SELECT_COMMANDE_BY_ID = "SELECT id_commande, total, id_table, id_etat_commande FROM COMMANDE WHERE id_Commande = :idCommande";
	private static final String INSERT_COMMANDE = "INSERT INTO COMMANDE(heure_preparation, total, id_table, id_etat_commande) VALUES(?,?,?,?)";
	private static final String INSERT_LIGNE_COMMANDE = "INSERT INTO LIGNECOMMANDE(id_commande, id_article, quantite) VALUES(?,?,?)";
	private static final String SELECT_COMMANDE = "select id_commande, total, heure_preparation, id_table , libelle from Commande inner join EtatCommande on EtatCommande.id_etat_commande = Commande.id_etat_commande where Commande.id_etat_commande != 3";
	private static final String SELECT_PREPARATION = "select Commande.id_commande, heure_preparation, nom, quantite, taille from Commande inner join LigneCommande on LigneCommande.id_commande = Commande.id_commande inner join Article on Article.id_article = LigneCommande.id_article where Commande.id_etat_commande =  1 order by Commande.id_commande";
	private static final String UPDATE_STATUT_COMMANDE = "UPDATE COMMANDE SET id_etat_commande = ? where id_commande = ? ";
	private static final String SELECT_PIZZA = "SELECT id_article ,nom, prix, taille, image from ARTICLE where nom like 'pizza%'";
	
	@Autowired
	public ArticleDAOJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

	}

	@Override
	public void insert(Article article) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> selectArticles() {
		List<Article> lstArticles = null;
		try {

			lstArticles = jdbcTemplate.query(SELECT_ARTICLES, new ArticleRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstArticles;
	}

	@Override
	public List<Article> selectEntree() {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_ENTREE, new ArticleTypeRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstArticles;
	}

	@Override
	public List<Article> selectPlat() {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_PLAT, new ArticleTypeRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstArticles;
	}

	@Override
	public List<Article> selectDessert() {
		List<Article> lstArticles = null;
		try {
			lstArticles = jdbcTemplate.query(SELECT_DESSERT, new ArticleTypeRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstArticles;
	}
	
	@Override
	public List<Article> SelectPizza() {
		List<Article> lstArticles = null;
		try {

			lstArticles = jdbcTemplate.query(SELECT_PIZZA, new ArticleRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstArticles;
	}

	public Article getArticleById(int idArticle) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("idArticle", idArticle);
		return namedJdbcTemplate.queryForObject(SELECT_ARTICLES_BY_ID, mapSqlParameterSource, new ArticleRowMapper());
	}

	public Commande getCommandeById(int idCommande) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("idCommande", idCommande);
		return namedJdbcTemplate.queryForObject(SELECT_COMMANDE_BY_ID, mapSqlParameterSource,
				new CommandeByIdRowMapper());
	}

	@Override
	public Object InsertCommande(Commande commande) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_COMMANDE, Statement.RETURN_GENERATED_KEYS);

				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MINUTE, 20);
				Timestamp DateHeure = new Timestamp(calendar.getTimeInMillis());

				ps.setTimestamp(1, DateHeure);
				ps.setInt(2, commande.getTotal());
				ps.setInt(3, commande.getNoTable());
				ps.setInt(4, commande.getStatutCommande().getidEtatCommande());

				return ps;
			}

		}, keyHolder);

		commande.setIdCommande(keyHolder.getKey().intValue());

		return jdbcTemplate.batchUpdate(INSERT_LIGNE_COMMANDE, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				LigneCommande ligne = commande.getLignesCommande().get(i);
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

	@Override
	public Object UpdateStatutCommande(Commande commande) {
		jdbcTemplate.update(UPDATE_STATUT_COMMANDE, commande.getStatutCommande().getidEtatCommande(), commande.getIdCommande());
		return commande;
	}

	@Override
	public List<Commande> SelectCommande() {
		List<Commande> lstCommandes = null;
		try {
			lstCommandes = jdbcTemplate.query(SELECT_COMMANDE, new CommandeRowMapper());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		}
		return lstCommandes;
	}

	public class PreparationTypeRowMapper implements RowMapper<Commande> {

		private Integer noCommandeCourant = null;
		private Commande commande = null;

		@Override
		public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
			int idCommande = rs.getInt("id_commande");
			LocalDateTime heurePreparation = rs.getTimestamp("heure_preparation").toLocalDateTime();
			String nomArticle = rs.getString("nom");
			int quantite = rs.getInt("quantite");
			String taille = rs.getString("taille");

			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setQuantite(quantite);

			Article article = new Article();
			article.setNom(nomArticle);
			article.setTaille(taille);
			ligneCommande.setArticle(article);

			// Vérifier si la commande a déjà été créée et se trouve dans le map
			if (noCommandeCourant == null || noCommandeCourant != idCommande) {
				commande = new Commande();
				commande.setIdCommande(idCommande);
				commande.setHeureCommande(heurePreparation);
				commande.setLignesCommande(new ArrayList<>());
			}

			// Ajouter la ligne de commande à la commande correspondante
			commande.ajouterLigneCommande(ligneCommande);

			return commande;
		}

		// Map pour stocker les commandes et leurs lignes de commande associées
		private final Map<Integer, Commande> commandesMap = new HashMap<>();
	}

	@Override
	public List<Commande> SelectPreparation() {
		Map<Integer, Commande> commandesMap = new HashMap<>();

		List<Commande> commandes = jdbcTemplate.query(SELECT_PREPARATION, new PreparationTypeRowMapper());

		for (Commande commande : commandes) {
			int idCommande = commande.getIdCommande();

			// Vérifier si la commande est déjà présente dans le map
			Commande existingCommande = commandesMap.get(idCommande);

			if (existingCommande != null) {
				// Si la commande est déjà dans le map, ajouter les articles à la commande
				// existante
				existingCommande.getLignesCommande().addAll(commande.getLignesCommande());
			} else {
				// Si la commande n'est pas dans le map, l'ajouter avec ses articles
				commandesMap.put(idCommande, commande);
			}
		}

		// Convertir la map en une liste pour renvoyer le résultat
		return new ArrayList<>(commandesMap.values());
	}

	static class ArticleRowMapper implements RowMapper<Article> {

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Article(rs.getInt("id_article"), rs.getString("nom"), rs.getInt("prix"), rs.getString("taille"));
		}
	}
	
	static class PizzaRowMapper implements RowMapper<Article> {

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Article(rs.getInt("id_article"), rs.getString("nom"), rs.getInt("prix"), rs.getString("taille"), rs.getString("image"));
		}
	}

	static class CommandeByIdRowMapper implements RowMapper<Commande> {

		@Override
		public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
			int idCommande = rs.getInt("id_commande");
			int total = rs.getInt("total");
			Timestamp heurePreparation = rs.getTimestamp("heure_preparation");
			int noTable = rs.getInt("id_table");
			int id_etat_commande = rs.getInt("id_etat_commande");

			EtatCommande statutCommande = new EtatCommande();
			statutCommande.setId_etat_commande(2);
			LocalDateTime heureCommande = heurePreparation.toLocalDateTime();

			return new Commande(idCommande, statutCommande, heureCommande, total, noTable);
		}
	}

	static class ArticleTypeRowMapper implements RowMapper<Article> {

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Article(rs.getInt("id_article"), rs.getString("nom"), rs.getInt("prix"));
		}
	}

	static class UpdateCommandeRowMapper implements RowMapper<Commande> {
		@Override
		public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
			int idCommande = rs.getInt("id_commande");

			return new Commande(idCommande);
		}
	}

	static class CommandeRowMapper implements RowMapper<Commande> {
		@Override
		public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
			int idCommande = rs.getInt("id_commande");
			int total = rs.getInt("total");
			Timestamp heurePreparation = rs.getTimestamp("heure_preparation");
			int noTable = rs.getInt("id_table");

			// Pour le statutCommande, nous devons d'abord extraire le libellé de la colonne
			// "libelle"
			String libelle = rs.getString("libelle");
			EtatCommande statutCommande = new EtatCommande();
			statutCommande.setLibelle(libelle);

			// Convertir le Timestamp en LocalDateTime (si vous utilisez Java 8 ou
			// supérieur)
			LocalDateTime heureCommande = heurePreparation.toLocalDateTime();

			// Créer et retourner une nouvelle instance de la classe Commande
			return new Commande(idCommande, statutCommande, heureCommande, total, noTable);
		}
	}

}
