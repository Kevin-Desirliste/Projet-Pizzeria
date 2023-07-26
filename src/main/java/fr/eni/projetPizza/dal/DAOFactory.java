package fr.eni.projetPizza.dal;

public abstract class DAOFactory {
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
}
