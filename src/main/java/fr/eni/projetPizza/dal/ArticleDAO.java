package fr.eni.projetPizza.dal;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.exception.DALException;

public interface ArticleDAO {

	public void insert(Article article) throws DALException;
	
}
