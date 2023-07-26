package fr.eni.projetPizza.bo;

public class Article {
	private int idArticle;
	private String nomArticle;
	private int prixArticle;
	
	public Article(String nomArticle) {
		super();
		this.nomArticle = nomArticle;
	}
	
	public Article(int idArticle, String nomArticle, int prixArticle) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.prixArticle = prixArticle;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public int getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(int prixArticle) {
		this.prixArticle = prixArticle;
	}
	
}
