package fr.eni.projetPizza.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.projetPizza.bo.Article;
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

}