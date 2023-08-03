package fr.eni.projetPizza.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.dal.ArticleDAO;

@Service
public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager(ArticleDAO articleDAO) { //injection par constructeur
		this.articleDAO = articleDAO;
	}
	
	public List<Article> selectArticles(){
		return articleDAO.selectArticles();
	}
	
	public List<Article> selectEntree(){
		return articleDAO.selectEntree();
	}
	
	public List<Article> selectPlat(){
		return articleDAO.selectPlat();
	}
	
	public List<Article> selectDessert(){
		return articleDAO.selectDessert();
	}
	public Object InsertCommande(Commande commande) {
		return articleDAO.InsertCommande(commande);
	}

	public Article getArticleById(int idArticle) {
		return articleDAO.getArticleById(idArticle);
	}
	
	public List<Commande> SelectCommande()  {
		return articleDAO.SelectCommande();
	}
	public Commande getCommandeById(int idCommande) {
		return articleDAO.getCommandeById(idCommande);
	}
	
	public List<Commande> SelectPreparation()  
	{
		return articleDAO.SelectPreparation();
	}
	
	public Object UpdateStatutCommande(Commande commande) {
		return articleDAO.UpdateStatutCommande(commande);
	}
	
	public List<Article> selectPizza(){
		return articleDAO.SelectPizza();
	}
	
}