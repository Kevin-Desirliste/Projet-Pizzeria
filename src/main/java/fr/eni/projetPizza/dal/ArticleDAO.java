package fr.eni.projetPizza.dal;

import java.util.List;

import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Table;
import fr.eni.projetPizza.exception.DALException;

public interface ArticleDAO {

	public void insert(Article article) throws DALException;

	public List<Table> selectTable() throws DALException;
	
}
