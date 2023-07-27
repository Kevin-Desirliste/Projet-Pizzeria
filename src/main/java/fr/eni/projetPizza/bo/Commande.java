package fr.eni.projetPizza.bo;

import java.time.LocalDate;

public class Commande {
	private int idCommande;
	private EtatCommande statutCommande;
	private LocalDate heureCommande;
	private int total;
	private int noTable;
	
	public Commande() {
	}
	
	public Commande( EtatCommande statutCommande, LocalDate heureCommande,  int noTable) {
		super();
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;
		this.noTable = noTable;
	}

	
	public Commande(int idCommande, EtatCommande statutCommande, LocalDate heureCommande,  int noTable) {
		super();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;
		this.noTable = noTable;
	}

	public Commande(int idCommande, EtatCommande statutCommande, LocalDate heureCommande) {
		super();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;

	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public EtatCommande getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(EtatCommande statutCommande) {
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

	public int getNoTable() {
		return noTable;
	}

	public void setNoTable(int noTable) {
		this.noTable = noTable;
	}
	
}

