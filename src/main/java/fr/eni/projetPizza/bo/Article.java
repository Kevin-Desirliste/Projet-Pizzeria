package fr.eni.projetPizza.bo;

public class Article {
	private int idArticle;
	private String nom;
	private int prix;
	private TypeArticle typeArticle;
	private String taille;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(String nomArticle) {
		super();
		this.nom = nomArticle;
	}

	public Article( String nomArticle, int prixArticle) {
		super();
		this.nom = nomArticle;
		this.prix = prixArticle;
	}
	
	public Article(int idArticle, String nomArticle, int prixArticle) {
		super();
		this.idArticle = idArticle;
		this.nom = nomArticle;
		this.prix = prixArticle;
	}


	
	public Article(int idArticle, String nomArticle, int prixArticle, String taille) {
		super();
		this.idArticle = idArticle;
		this.nom = nomArticle;
		this.prix = prixArticle;
		this.taille = taille;
	}

	public Article(int idArticle, String nomArticle, int prixArticle, String taille, TypeArticle TypeArticle) {
		super();
		this.idArticle = idArticle;
		this.nom = nomArticle;
		this.prix = prixArticle;
		this.taille = taille;
		this.typeArticle = typeArticle;
	}

	
	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomArticle) {
		this.nom = nomArticle;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prixArticle) {
		this.prix = prixArticle;
	}

	public TypeArticle getTypeArticle() {
		return typeArticle;
	}

	public void setTypeArticle(TypeArticle typeArticle) {
		this.typeArticle = typeArticle;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nom + ", prixArticle=" + prix
				+ ", typePlat=" + typeArticle + ", taille=" + taille + "]";
	}
	
}
