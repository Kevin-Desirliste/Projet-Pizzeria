package fr.eni.projetPizza.dal;

import java.util.List;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.bo.EtatCommande;
import fr.eni.projetPizza.exception.DALException;

public interface ArticleDAO {

	public void insert(Article article) throws DALException;

	public List<Article> selectArticles() ;

	public List<Article> selectEntree();

	public List<Article> selectPlat();
	
	public List<Article> selectDessert();

	public Object InsertCommande(Commande commande);

	public Article getArticleById(int idArticle);

	public List<Commande> SelectCommande();

	public List<Commande> SelectPreparation();

	public Commande getCommandeById(int idCommande);

	public Object UpdateStatutCommande(Commande commande);


	
}
