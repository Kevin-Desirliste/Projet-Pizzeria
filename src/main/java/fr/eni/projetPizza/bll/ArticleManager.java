package fr.eni.projetPizza.bll;

import fr.eni.projetPizza.dal.ArticleDAO;
import fr.eni.projetPizza.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

}