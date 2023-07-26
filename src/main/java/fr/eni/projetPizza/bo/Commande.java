package fr.eni.projetPizza.bo;

import java.time.LocalDate;

public class Commande {
	private int idCommande;
	private String statutCommande;
	private LocalDate heureCommande;
	private int total;
	
	public Commande(int idCommande, String statutCommande, LocalDate heureCommande, int total) {
		super();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;
		this.total = total;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}

	public LocalDate getHeureCommande() {
		return heureCommande;
	}

	public void setHeureCommande(LocalDate heureCommande) {
		this.heureCommande = heureCommande;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}

