package fr.eni.projetPizza.bo;

public class Serveur {

	private int idServeur;
	private String libelle;
	
	public Serveur() {
		
	}
	
	public Serveur(int idUtilisateur, String libelle, int idServeur) {
		super();
		this.idServeur = idServeur;
		this.libelle = libelle;
	}
	
	public int getIdServeur() {
		return idServeur;
	}
	
	public void setIdServeur(int idServeur) {
		this.idServeur = idServeur;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
