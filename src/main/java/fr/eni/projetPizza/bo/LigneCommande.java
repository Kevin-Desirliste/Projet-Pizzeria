package fr.eni.projetPizza.bo;

public class LigneCommande {
	private Article article;
//	private Commande commande;
	private int quantite;
	
	public LigneCommande() {
	}

	public LigneCommande(Article article,  int quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Contenir [article=" + article +  ", quantite=" + quantite + "]";
	}
	
	

}
