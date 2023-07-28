package fr.eni.projetPizza.bo;

public class EtatCommande {
	private int idEtatCommande;
	private String libelle;
	
	public EtatCommande(int idEtatCommande, String libelle) {
		super();
		this.idEtatCommande = idEtatCommande;
		this.libelle = libelle;
	}

	public int getidEtatCommande() {
		return idEtatCommande;
	}

	public void setId_etat_commande(int idEtatCommande) {
		this.idEtatCommande = idEtatCommande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void add(EtatCommande table) {
		// TODO Auto-generated method stub
		
	}
		
}
