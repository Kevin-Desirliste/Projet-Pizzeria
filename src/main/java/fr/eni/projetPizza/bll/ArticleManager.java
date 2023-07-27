package fr.eni.projetPizza.bll;

import com.microsoft.sqlserver.jdbc.StringUtils;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.dal.ArticleDAO;
import fr.eni.projetPizza.dal.DAOFactory;
import fr.eni.projetPizza.exception.BusinessException;
import fr.eni.projetPizza.exception.DALException;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

}