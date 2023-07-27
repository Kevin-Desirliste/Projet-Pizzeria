package fr.eni.projetPizza.bo;

public class TypeArticle {
	private int idTypeArticle;
	private String libelle;
	
	public TypeArticle(int idTypeArticle, String libelle) {
		super();
		this.idTypeArticle = idTypeArticle;
		this.libelle = libelle;
	}

	public int getidTypeArticle() {
		return idTypeArticle;
	}

	public void setidTypeArticle(int idTypeArticle) {
		this.idTypeArticle = idTypeArticle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelleTable(String libelle) {
		this.libelle = libelle;
	}
		
}
